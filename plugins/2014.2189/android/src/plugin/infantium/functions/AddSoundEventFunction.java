package plugin.infantium.functions;

import android.util.Log;
import com.naef.jnlua.LuaState;
import com.naef.jnlua.NamedJavaFunction;
import com.ansca.corona.CoronaLua;
import com.naef.jnlua.LuaRuntimeException;

import com.infantium.android.sdk.InfantiumSDK;
import com.infantium.android.sdk.InfantiumResponse;
import com.infantium.android.sdk.events.SoundEvent;
import com.infantium.android.sdk.constants.Conf;

import java.lang.IllegalArgumentException;

import plugin.infantium.LuaLoader;

/** Implements the infantium.init() Lua function. */
public class AddSoundEventFunction implements NamedJavaFunction {
	private static final String FUNCTION_NAME = "addSoundEvent";

	// Log TAG
	private static final String LOG_TAG = "Infantium Corona Plugin";
	
	/**
	 * Gets the name of the Lua function as it would appear in the Lua script.
	 * @return Returns the name of the custom Lua function.
	 */
	@Override
	public String getName() {
		//Log.d(LOG_TAG, FUNCTION_NAME + " getName called.");
		return FUNCTION_NAME;
	}
	
	/**
	 * This method is called when the Lua function is called.
	 * <p>
	 * Warning! This method is not called on the main UI thread.
	 * @param luaState Reference to the Lua state.
	 *                 Needed to retrieve the Lua function's parameters and to return values back to Lua.
	 * @return Returns the number of values to be returned by the Lua function.
	 */
	@Override
	public int invoke(LuaState L) {
		//Log.d(LOG_TAG, FUNCTION_NAME + " invoke called.");
		return addSoundEvent(L);
	}
	
	/**
	 * Method which implements the function logic. The parameters in the stack should be:
	 * 0: String event_id
	 * 1: String sound_type (optional). "" if empty.
	 * 2: String associated_text (optional). "" if empty.
	 * 3: String language (optional). "" if empty.
	 * 4: Double imprecise_sound_volume (optional). -1.0 if empty.
	 * 5: Long duration (optional). -1L if not used.
	 */
	public int addSoundEvent(LuaState L) {
		InfantiumResponse resp = InfantiumResponse.EmptyField;
		
		try {
			String event_id = L.checkString(1);
			String type = L.checkString(2);
			String associated_text = L.checkString(3);
			String language = L.checkString(4);
			Double imprecise_sound_volume = L.checkNumber(5);
			Long duration = new Long(Math.round(L.checkNumber(6)));

			SoundEvent ev = new SoundEvent(event_id);
			if(!"".equals(type)) {
				ev.set_t(type);
			}
			if(!"".equals(associated_text) && !"".equals(language)) {
				ev.set_associated_text(associated_text, language);
			} else if (!"".equals(associated_text)) {
				ev.set_associated_text(associated_text);
			}
			if(!imprecise_sound_volume.equals(-1.0)) {
				if(Conf.D) Log.i(LOG_TAG, FUNCTION_NAME + " imprecise_sound_volume set to: " + imprecise_sound_volume);
				ev.set_imprecise_sound_volume(imprecise_sound_volume);
			}
			if(!duration.equals(-1L)) {
				if(Conf.D) Log.i(LOG_TAG, FUNCTION_NAME + " duration set to: " + duration);
				ev.set_duration(duration);
			}

			resp = LuaLoader.infantium.addEvent(ev);

			if(InfantiumResponse.Valid.equals(resp)) {
				if(Conf.D) Log.i(LOG_TAG, FUNCTION_NAME + " successful.");
			} else {
				Log.e(LOG_TAG, FUNCTION_NAME + " failed: " + resp.toString() + ".");
			}
				
			L.pushString(resp.toString());
			return 1;
			
		} catch (LuaRuntimeException lre) {
			Log.e(LOG_TAG, FUNCTION_NAME + " failed with LuaRuntimeException: " + lre.getMessage());
			
		} catch (IllegalArgumentException iae) {
			Log.e(LOG_TAG, FUNCTION_NAME + " failed with IllegalArgumentException: " + iae.getMessage() + "." +
				"This may be due to sending a parameter of a different type or less parameters than required.");
			
		} catch (Exception e) {
			Log.e(LOG_TAG, FUNCTION_NAME + " failed with Exception " + e.getClass().getName() + ": " + e.getMessage());
			
		}
		
		return 0;
	}
}