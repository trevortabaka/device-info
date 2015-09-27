package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.api.StringApi;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class ActivityManager implements Class_ {
    private final android.app.ActivityManager activityManager;
    private final Collection<Api> apis;

    @Inject
    public ActivityManager(android.app.ActivityManager activityManager) {
        this.activityManager = activityManager;
        apis = new ArrayList<>();
        if (SdkUtil.IS_ECLAIR) addEclairApis();
    }

    @TargetApi(SdkUtil.ECLAIR)
    private void addEclairApis() {
        int apiLevel = SdkUtil.ECLAIR;
        apis.add(new StringApi(apiLevel, "memoryClass", activityManager.getMemoryClass() + " MiB"));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
