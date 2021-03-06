//
//  LuaLoader.java
//
//  MIT License 2014 Infantium.
//

// This corresponds to the name of the Lua library
package plugin.infantium;

import android.app.Activity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.naef.jnlua.LuaState;
import com.naef.jnlua.JavaFunction;
import com.naef.jnlua.NamedJavaFunction;
import com.ansca.corona.CoronaActivity;
import com.ansca.corona.CoronaEnvironment;
import com.ansca.corona.CoronaLua;
import com.ansca.corona.CoronaRuntime;
import com.ansca.corona.CoronaRuntimeListener;

import android.os.Handler;
import java.lang.Runnable;

import plugin.infantium.functions.*;

import com.infantium.android.sdk.InfantiumSDK;


/**
 * Implements the Lua interface for a Corona plugin.
 * <p>
 * Only one instance of this class will be created by Corona for the lifetime of the application.
 * This instance will be re-used for every new Corona activity that gets created.
 */
public class LuaLoader implements JavaFunction, CoronaRuntimeListener {
	/** Lua registry ID to the Lua function to be called when the ad request finishes. */
	public static int fListener;

	// Log TAG
	private static final String LOG_TAG = "Infantium Corona Plugin";
	
	// Infantium SDK
	public static InfantiumSDK infantium;

	/**
	 * Creates a new Lua interface to this plugin.
	 * <p>
	 * Note that a new LuaLoader instance will not be created for every CoronaActivity instance.
	 * That is, only one instance of this class will be created for the lifetime of the application process.
	 * This gives a plugin the option to do operations in the background while the CoronaActivity is destroyed.
	 */
	public LuaLoader() {
		// Initialize member variables.
		fListener = CoronaLua.REFNIL;

		// Set up this plugin to listen for Corona runtime events to be received by methods
		// onLoaded(), onStarted(), onSuspended(), onResumed(), and onExiting().
		CoronaEnvironment.addRuntimeListener(this);
		
		CoronaActivity activity = CoronaEnvironment.getCoronaActivity();
		Handler handler = activity.getHandler();
		
		Log.i(LOG_TAG, "Received '" + handler.postAtFrontOfQueue(new Runnable() {
			
			@Override
			public void run () {
				Log.d(LOG_TAG, "Started loading Runnable on LuaLoader()...");
				infantium = InfantiumSDK.getInfantiumSDK(CoronaEnvironment.getApplicationContext());
				Log.d(LOG_TAG, "... and finished loading Runnable on LuaLoader()");
			}
		}) + "' when sending the runnable.");
	}

	/**
	 * Called when this plugin is being loaded via the Lua require() function.
	 * <p>
	 * Note that this method will be called everytime a new CoronaActivity has been launched.
	 * This means that you'll need to re-initialize this plugin here.
	 * <p>
	 * Warning! This method is not called on the main UI thread.
	 * @param L Reference to the Lua state that the require() function was called from.
	 * @return Returns the number of values that the require() function will return.
	 *         <p>
	 *         Expected to return 1, the library that the require() function is loading.
	 */
	@Override
	public int invoke(LuaState L) {
		// Register this plugin into Lua with the following functions.
		NamedJavaFunction[] luaFunctions = new NamedJavaFunction[] {
			new InitFunction(),
			new SetDeveloperCredentialsFunction(),
			new SetDeviceInfoFunction(),
			new SetContentAppFunction(),
			new SetSubcontentFunction(),
			new CreateGameplayFunction(),
			new CloseGameplayFunction(),
			new AddElementFunction(),
			new AddNumberElementFunction(),
			new AddTextElementFunction(),
			new AddShapeElementFunction(),
			new AddPaintedElementFunction(),
			new AddPictureElementFunction(),
			new AddGoalFunction(),
			new AddSelectionGoalFunction(),
			new AddMatchingGoalFunction(),
			new AddTappingGoalFunction(),
			new AddEventFunction(),
			new AddSoundEventFunction(),
			new StartPlayingFunction(),
			new NewBasicInteractionFunction(),
			new TriggerExistingEventFunction(),
			new SendGameRawdataFunction(),
			new ReturnToInfantiumAppFunction()
		};
		String libName = L.toString( 1 );
		L.register(libName, luaFunctions);

		// Returning 1 indicates that the Lua require() function will return the above Lua library.
		return 1;
	}

	/**
	 * Called after the Corona runtime has been created and just before executing the "main.lua" file.
	 * <p>
	 * Warning! This method is not called on the main thread.
	 * @param runtime Reference to the CoronaRuntime object that has just been loaded/initialized.
	 *                Provides a LuaState object that allows the application to extend the Lua API.
	 */
	@Override
	public void onLoaded(CoronaRuntime runtime) {
		// Note that this method will not be called the first time a Corona activity has been launched.
		// This is because this listener cannot be added to the CoronaEnvironment until after
		// this plugin has been required-in by Lua, which occurs after the onLoaded() event.
		// However, this method will be called when a 2nd Corona activity has been created.
		//Log.d(LOG_TAG, "onLoaded called.");
	}

	/**
	 * Called just after the Corona runtime has executed the "main.lua" file.
	 * <p>
	 * Warning! This method is not called on the main thread.
	 * @param runtime Reference to the CoronaRuntime object that has just been started.
	 */
	@Override
	public void onStarted(CoronaRuntime runtime) {
	}

	/**
	 * Called just after the Corona runtime has been suspended which pauses all rendering, audio, timers,
	 * and other Corona related operations. This can happen when another Android activity (ie: window) has
	 * been displayed, when the screen has been powered off, or when the screen lock is shown.
	 * <p>
	 * Warning! This method is not called on the main thread.
	 * @param runtime Reference to the CoronaRuntime object that has just been suspended.
	 */
	@Override
	public void onSuspended(CoronaRuntime runtime) {
		Log.d(LOG_TAG, "Calling onPauseInfantium.");
		//getInfantium().onPauseInfantium();
		infantium.onPauseInfantium();
	}

	/**
	 * Called just after the Corona runtime has been resumed after a suspend.
	 * <p>
	 * Warning! This method is not called on the main thread.
	 * @param runtime Reference to the CoronaRuntime object that has just been resumed.
	 */
	@Override
	public void onResumed(CoronaRuntime runtime) {
		Log.d(LOG_TAG, "Calling onResumeInfantium.");
		infantium.onResumeInfantium();
		//getInfantium().onResumeInfantium();
		//CoronaActivity activity = CoronaEnvironment.getCoronaActivity();
		//Handler handler = activity.getHandler();
		
		//handler.post(new Runnable() {
			
		//	@Override
		//	public void run () {
		//		Log.d(LOG_TAG, "Calling Runnable onResumeInfantium.");
		//		infantium = InfantiumSDK.getInfantiumSDK(CoronaEnvironment.getApplicationContext());
		//		infantium.onResumeInfantium();
		//	}
		//});
	}

	/**
	 * Called just before the Corona runtime terminates.
	 * <p>
	 * This happens when the Corona activity is being destroyed which happens when the user presses the Back button
	 * on the activity, when the native.requestExit() method is called in Lua, or when the activity's finish()
	 * method is called. This does not mean that the application is exiting.
	 * <p>
	 * Warning! This method is not called on the main thread.
	 * @param runtime Reference to the CoronaRuntime object that is being terminated.
	 */
	@Override
	public void onExiting(CoronaRuntime runtime) {
		// Remove the Lua listener reference.
		CoronaLua.deleteRef( runtime.getLuaState(), fListener );
		fListener = CoronaLua.REFNIL;
		Log.d(LOG_TAG, "Called onExiting. Calling onPauseInfantium.");
		infantium.onPauseInfantium();
	}
}
