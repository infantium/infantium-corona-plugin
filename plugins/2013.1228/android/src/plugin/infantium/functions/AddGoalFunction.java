package plugin.infantium.functions;

import android.util.Log;
import com.naef.jnlua.LuaState;
import com.naef.jnlua.NamedJavaFunction;
import com.ansca.corona.CoronaLua;
import com.naef.jnlua.LuaRuntimeException;

import com.infantium.android.sdk.InfantiumSDK;
import com.infantium.android.sdk.InfantiumResponse;
import com.infantium.android.sdk.goals.Goal;
import com.infantium.android.sdk.constants.Conf;

import java.lang.IllegalArgumentException;

import plugin.infantium.LuaLoader;

/** Implements the infantium.init() Lua function. */
public class AddGoalFunction implements NamedJavaFunction {
	private static final String FUNCTION_NAME = "addGoal";

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
		return addGoal(L);
	}
	
	/**
	 * Method which implements the function logic. The parameters in the stack should be:
	 * 0: String goal_id
	 * 1: Integer time_limit (optional). -1 if empty.
	 * 2: Boolean auto_eval (optional). true by default.
	 * 3: String instructions (optional). "" if empty.
	 */
	public int addGoal(LuaState L) {
		InfantiumResponse resp = InfantiumResponse.EmptyField;
		
		try {
			String goal_id = L.checkString(1);
			Long time_limit = Long.valueOf(L.checkInteger(2));
			Boolean auto_eval = L.checkBoolean(3);
			String instructions = L.checkString(4);

			Goal goal = new Goal(goal_id);
			if(!time_limit.equals(-1L)) {
				goal.set_time_limit(time_limit);
			}
			goal.set_auto_eval(auto_eval);
			if(!"".equals(instructions)) {
				if(Conf.D) Log.i(LOG_TAG, FUNCTION_NAME + " set Goal instructions: '" + instructions + "'.");
				goal.set_instructions(instructions);
			}

			resp = LuaLoader.infantium.addGoal(goal);

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