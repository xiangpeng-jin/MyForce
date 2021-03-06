package com.tools.accessibility.uiinterface;

import android.os.IBinder;

import com.tools.ipc.LocalServiceManager;
import com.xiang.batterytest.battery.IAccessibilityServiceInterface;

import java.util.List;

/**
 * Created by jinxiangpeng on 2017/2/22.
 */

public class AccessibiltyManager {

    private static AccessibiltyManager mInstance;
    private IAccessibilityServiceInterface mIAccessibilityServiceInterface;


    public static AccessibiltyManager getInstance() {
        if (null == mInstance) {
            synchronized (AccessibiltyManager.class){
                if(mInstance == null){
                    mInstance = new AccessibiltyManager();
                }
            }
        }
        return mInstance;
    }

    private AccessibiltyManager() {
        IBinder vBinder = LocalServiceManager.getInstance().getService("accessibility_service");
        mIAccessibilityServiceInterface = IAccessibilityServiceInterface.Stub.asInterface(vBinder);
    }

    public boolean setInterruptFlag(boolean flag) {
        try {
            mIAccessibilityServiceInterface.setInterruptFlag(flag);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void startForceStop(IBinder messenger, List<String> pnames){
        try{
            mIAccessibilityServiceInterface.startForceStop(messenger, pnames);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isServiceEnable(){
        boolean vRet = false;
        try{
            vRet = mIAccessibilityServiceInterface.isServiceEnable();
        }
        catch (Exception e){
            e.printStackTrace();
            vRet = false;
        }
        return vRet;
    }
}
