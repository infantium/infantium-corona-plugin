package plugin.infantium.functions;

import android.util.Log;
import com.naef.jnlua.LuaState;
import com.naef.jnlua.NamedJavaFunction;
import com.ansca.corona.CoronaLua;
import com.ansca.corona.CoronaEnvironment;

import com.infantium.android.sdk.InfantiumSDK;

import plugin.infantium.LuaLoader;

/** Implements the infantium.init() Lua function. */
public class InitFunction implements NamedJavaFunction {

	/** This corresponds to the event name, e.g. [Lua] event.name */
	private static final String EVENT_NAME = "plugininfantiumevent";

	// Log TAG
	private static final String LOG_TAG = "Infantium Corona Plugin";
	
	// Infantium SDK
	private static InfantiumSDK infantium;

	private InfantiumSDK getInfantium() {
		if(infantium==null) {
			infantium = InfantiumSDK.getInfantiumSDK(CoronaEnvironment.getApplicationContext());
		}
		return infantium;
	}
	
	/**
	 * Gets the name of the Lua function as it would appear in the Lua script.
	 * @return Returns the name of the custom Lua function.
	 */
	@Override
	public String getName() {
		//Log.d(LOG_TAG, "InitFunction getName called.");
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
		//Log.d(LOG_TAG, "InitFunction invoke called.");
		return init(L);
	}
	
	/**
	 * The following Lua function has been called:  library.init( listener )
	 * <p>
	 * Warning! This method is not called on the main thread.
	 * @param L Reference to the Lua state that the Lua function was called from.
	 * @return Returns the number of values to be returned by the library.init() function.
	 */
	public int init(LuaState L) {	
		Log.d(LOG_TAG, "InitFunction called");
		LuaLoader.infantium.onResumeInfantium();
		
		Log.i(LOG_TAG, "Loaded InfantiumSDK. Version: " + InfantiumSDK.version);
		int listenerIndex = 1;

		if ( CoronaLua.isListener( L, listenerIndex, EVENT_NAME ) ) {
			LuaLoader.fListener = CoronaLua.newRef( L, listenerIndex );
		}
		
		LuaLoader.infantium.setDeveloperCredentials("User!", "API_KEYYYYY");
		Log.d(LOG_TAG, "setDeveloperCredentials called");
		return 0;
	}
}