package plugin.infantium.functions;

import android.util.Log;
import com.naef.jnlua.LuaState;
import com.naef.jnlua.NamedJavaFunction;
import com.ansca.corona.CoronaLua;

import com.infantium.android.sdk.InfantiumSDK;

import plugin.infantium.LuaLoader;

/** Implements the infantium.init() Lua function. */
public class InitFunction implements NamedJavaFunction {
	private static final String FUNCTION_NAME = "InitFunction";

	// Log TAG
	private static final String LOG_TAG = "Infantium Corona Plugin";
	
	/**
	 * Gets the name of the Lua function as it would appear in the Lua script.
	 * @return Returns the name of the custom Lua function.
	 */
	@Override
	public String getName() {
		//Log.d(LOG_TAG, FUNCTION_NAME + " getName called.");
		return "init";
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
		return init(L);
	}
	
	/**
	 * Method which implements the function logic.
	 */
	public int init(LuaState L) {
		LuaLoader.infantium.onResumeInfantium();		
		Log.i(LOG_TAG, "Loaded InfantiumSDK. Version: " + InfantiumSDK.version);
		
		return 0;
	}
}