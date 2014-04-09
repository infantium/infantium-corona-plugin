package plugin.infantium.functions;

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

import plugin.infantium.LuaLoader;

/** Implements the library.show() Lua function. */
public class ShowFunction implements NamedJavaFunction {
	
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
		Log.d(LOG_TAG, "ShowFunction getName called.");
		return "show";
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
		Log.d(LOG_TAG, "ShowFunction invoke called.");
		return show(L);
	}
	
	public int show(LuaState L) {
		Log.d(LOG_TAG, "ShowFunction called.");
		// Fetch a reference to the Corona activity.
		// Note: Will be null if the end-user has just backed out of the activity.
		CoronaActivity activity = CoronaEnvironment.getCoronaActivity();
		if (activity == null) {
			return 0;
		}

		// Fetch the first argument from the called Lua function.
		String word = L.checkString( 1 );
		if ( null == word ) {
			word = "corona";
		}

		// Create web view on the main UI thread.
		if (activity != null) {
			final String url = "http://dictionary.reference.com/browse/" + word;
			activity.runOnUiThread(new Runnable() {
				@Override
				public void run() {
					// Fetch a reference to the Corona activity.
					// Note: Will be null if the end-user has just backed out of the activity.
					CoronaActivity activity = CoronaEnvironment.getCoronaActivity();
					if (activity == null) {
						return;
					}

					// Create and set up the web view.
					WebView view = new WebView(activity);

					// Prevent redirect which causes an external browser to be launched
					// because some sites detect phone/tablet and redirect.
					view.setWebViewClient(new WebViewClient() {
						@Override
						public boolean shouldOverrideUrlLoading(WebView view, String url) {
							return false;
						}
					});

					// Display the web view.
					activity.getOverlayView().addView(view);
					view.loadUrl( url );
				}
			} );
		}

		return 0;
	}
}