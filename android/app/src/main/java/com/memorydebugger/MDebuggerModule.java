package com.memorydebugger;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

import android.content.Context;
import android.widget.Toast;
import android.app.ActivityManager;

public class MDebuggerModule extends ReactContextBaseJavaModule {
  ReactApplicationContext reactContext;
  
  public MDebuggerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }
 
  @Override
  public String getName() {
    return "MDebugger";
  }

  @ReactMethod
  public void isLowMemory(Promise p) {
    ActivityManager actMgr = (ActivityManager) this.reactContext.getSystemService(Context.ACTIVITY_SERVICE);
    ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
    actMgr.getMemoryInfo(memInfo);
    p.resolve(memInfo.lowMemory);
  }
}
