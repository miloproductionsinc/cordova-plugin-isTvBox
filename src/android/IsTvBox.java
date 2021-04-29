package com.shahid.cordova.plugin;
import android.widget.Toast;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.UiModeManager;
import android.content.res.Configuration;
import android.util.Log;
import android.content.Context;
public class IsTvBox extends CordovaPlugin {
  public static final String TAG = "DeviceTypeRuntimeCheck";
  public static final String UI_MODE_SERVICE = "uimode";
  public Context context;
  @Override
  public boolean execute(String action, JSONArray args,
    final CallbackContext callbackContext) {
      // Verify that the user sent a 'checkTvBox' action
      if (!action.equals("checkTvBox")) {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;
      }
      String deviceInfo = "";
      try {
        JSONObject options = args.getJSONObject(0);
        // message = options.getString("message");
        // duration = options.getString("duration");
      } catch (JSONException e) {
        callbackContext.error("Error encountered: " + e.getMessage());
        return false;
      }
      // will check that if app is running on android Tv or Android mobile
      UiModeManager uiModeManager = (UiModeManager) cordova.getActivity().getApplicationContext().getSystemService(Context.UI_MODE_SERVICE);
      if (uiModeManager.getCurrentModeType() == Configuration.UI_MODE_TYPE_TELEVISION) {
          Log.d(TAG, "TV Device");
          
          deviceInfo = "TV Device";
         
      } else {
          Log.d(TAG, "Non-TV Device");
       
          deviceInfo = "Non-TV Device";
         
      }
      callbackContext.success(deviceInfo);
      return true;
     
     
  }
}