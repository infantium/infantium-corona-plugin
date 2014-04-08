package plugin.infantium.functions;

import android.util.Log;
import com.naef.jnlua.LuaState;
import com.naef.jnlua.NamedJavaFunction;
import com.ansca.corona.CoronaLua;
import com.naef.jnlua.LuaRuntimeException;

import com.infantium.android.sdk.InfantiumSDK;

import java.lang.IllegalArgumentException;

import plugin.infantium.LuaLoader;

/** Implements the infantium.init() Lua function. */
public class SetDeveloperCredentialsFunction implements NamedJavaFunction {
	private static final String FUNCTION_NAME = "setDeveloperCredentials";

	/** This corresponds to the event name, e.g. [Lua] event.name */
	private static final String EVENT_NAME = "plugininfantiumevent";

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
		return setDeveloperCredentials(L);
	}
	
	/**
	 * Method which implements the function logic. The parameters in the stack should be:
	 * 0: String api_username
	 * 1: String api_key
	 */
	public int setDeveloperCredentials(LuaState L) {
		
		try {
			String api_user = L.checkString(1);
			String api_key = L.checkString(2);
			
			LuaLoader.infantium.setDeveloperCredentials(api_user, api_key);
			Log.d(LOG_TAG, FUNCTION_NAME + " called.");
			
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