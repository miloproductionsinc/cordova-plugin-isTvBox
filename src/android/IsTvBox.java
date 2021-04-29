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
    final CallbackContext callbackContext) throws JSONException {
      // Verify that the user sent a 'checkTvBox' action
      if (!action.equals("checkTvBox")) {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;
      }
     
    
      // will check that if app is running on android Tv or Android mobile
      JSONObject r = new JSONObject();
            r.put("isTvBox", this.isTv());
            r.put("isTouchScreen", this.isTouch());
          
      callbackContext.success(r);
      return true;
     
     
  }

  public boolean isTv(){
    UiModeManager uiModeManager = (UiModeManager) cordova.getActivity().getApplicationContext().getSystemService(Context.UI_MODE_SERVICE);
    if (uiModeManager.getCurrentModeType() == Configuration.UI_MODE_TYPE_TELEVISION) {
        Log.d(TAG, "TV Device");
        
       return true;
       
    } else {
        Log.d(TAG, "Non-TV Device");
     
      return false;
       
    }
  }
  public boolean isTouch(){
    return cordova.getActivity().getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen");
  }
}