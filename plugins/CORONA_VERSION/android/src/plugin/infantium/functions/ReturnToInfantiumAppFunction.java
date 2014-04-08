package plugin.infantium.functions;

import android.util.Log;
import com.naef.jnlua.LuaState;
import com.naef.jnlua.NamedJavaFunction;
import com.ansca.corona.CoronaLua;
import com.ansca.corona.CoronaEnvironment;
import com.naef.jnlua.LuaRuntimeException;

import com.infantium.android.sdk.InfantiumSDK;
import com.infantium.android.sdk.InfantiumResponse;
import com.infantium.android.sdk.constants.Conf;

import java.lang.IllegalArgumentException;

import plugin.infantium.LuaLoader;

/** Implements the infantium.init() Lua function. */
public class ReturnToInfantiumAppFunction implements NamedJavaFunction {
	private static final String FUNCTION_NAME = "returnToInfantiumApp";

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
		return returnToInfantiumApp(L);
	}
	
	/**
	 * Method which implements the function logic. This method uses no parameters.
	 */
	public int returnToInfantiumApp(LuaState L) {
		InfantiumResponse resp = InfantiumResponse.EmptyField;
		
		try {
			Boolean returned = LuaLoader.infantium.returnToInfantiumApp(CoronaEnvironment.getCoronaActivity());

			if(returned) {
				resp = InfantiumResponse.Valid;
				if(Conf.D) Log.i(LOG_TAG, FUNCTION_NAME + " successful.");
			} else {
				Log.e(LOG_TAG, FUNCTION_NAME + " failed.");
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