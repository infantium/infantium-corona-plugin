package plugin.infantium.functions;

import android.util.Log;
import com.naef.jnlua.LuaState;
import com.naef.jnlua.NamedJavaFunction;
import com.ansca.corona.CoronaLua;
import com.naef.jnlua.LuaRuntimeException;

import com.infantium.android.sdk.InfantiumSDK;
import com.infantium.android.sdk.InfantiumResponse;
import com.infantium.android.sdk.constants.Conf;

import java.lang.IllegalArgumentException;
import org.json.JSONObject;

import plugin.infantium.LuaLoader;

/** Implements the infantium.init() Lua function. */
public class NewBasicInteractionFunction implements NamedJavaFunction {
	private static final String FUNCTION_NAME = "newBasicInteraction";

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
		return newBasicInteraction(L);
	}
	
	/**
	 * Method which implements the function logic. The parameters in the stack should be:
	 * 0: String interaction_type
	 * 1: String object_type (optional). "" if empty.
	 * 2: String goal_type
	 * 3: Integer lifetime (optional). -1 if empty.
	 * 4: Integer n_concurrent_oks (optional). -1 if empty.
	 * 5: Integer n_concurrent_kos (optional). -1 if empty.
	 */
	public int newBasicInteraction(LuaState L) {
		InfantiumResponse resp = InfantiumResponse.EmptyField;
		
		try {
			String interaction_t = L.checkString(1);
			String object_type = L.checkString(2);
			String goal_type = L.checkString(3);
			Integer lifetime = L.checkInteger(4);
			Integer n_concurrent_oks = L.checkInteger(5);
			Integer n_concurrent_kos = L.checkInteger(6);

			if ("".equals(object_type)) {
				object_type = null;
				if(Conf.D) Log.i(LOG_TAG, "New '" + interaction_t + "' interaction: [" + object_type + ", " + goal_type + "]");
				if(object_type != null)
					Log.i(LOG_TAG, "Should not enter here... " + object_type.toLowerCase());
				if(Conf.D) Log.i(LOG_TAG, FUNCTION_NAME + " without object_type.");
			}
			
			JSONObject interaction_json = new JSONObject();
			interaction_json.put("object_type", object_type);
			if(Conf.D) Log.i(LOG_TAG, FUNCTION_NAME + " interaction_json: " + interaction_json.toString());

			if(lifetime.equals(-1) && n_concurrent_oks.equals(-1) && n_concurrent_kos.equals(-1)) {
				resp = LuaLoader.infantium.newBasicInteraction(interaction_t, object_type, goal_type);

			} else if (n_concurrent_oks.equals(-1) && n_concurrent_kos.equals(-1)) {
				resp = LuaLoader.infantium.newBasicInteraction(interaction_t, object_type, goal_type, lifetime);

			} else if (lifetime.equals(-1)) {
				resp = LuaLoader.infantium.newBasicInteraction(interaction_t, object_type, goal_type, 
						n_concurrent_oks, n_concurrent_kos);

			} else {
				resp = LuaLoader.infantium.newBasicInteraction(interaction_t, object_type, goal_type, lifetime,
						n_concurrent_oks, n_concurrent_kos);

			}

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