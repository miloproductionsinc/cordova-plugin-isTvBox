package com.shahid.cordova.plugin;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;

public class IsTvBox extends CordovaPlugin {
  public static final String TAG = "DeviceTypeRuntimeCheck";
  
  @Override
  public boolean execute(String action, JSONArray args,
    final CallbackContext callbackContext) throws JSONException {
      // TODO needed for multiple functionalities. Later on, verify if we need to keep it.
      // Verify that the user sent a 'checkTvBox' action
      if (!action.equals("checkTvBox")) {
        callbackContext.error("\"" + action + "\" is not a recognized action.");
        return false;
      }

      JSONObject result = new JSONObject()
            .put("isTv", isTv())
            .put("hasTouchScreen", hasTouchScreen());
          
      callbackContext.success(result);
      return true;
  }

  private boolean isTv(){
    UiModeManager uiModeManager = (UiModeManager) cordova.getActivity().getApplicationContext().getSystemService(Context.UI_MODE_SERVICE);
    boolean isTv = uiModeManager.getCurrentModeType() == Configuration.UI_MODE_TYPE_TELEVISION;

    Log.d(TAG, isTv ? "TV Device" : "Non-TV Device");

    return isTv;
  }

  private boolean hasTouchScreen(){
    return cordova.getActivity().getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.touchscreen");
  }
}