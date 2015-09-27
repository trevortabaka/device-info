package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.StringApi;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class ActivityManager implements ApiGroup {
    private final android.app.ActivityManager activityManager;
    private final Collection<Api> apis;

    @Inject
    public ActivityManager(android.app.ActivityManager activityManager) {
        this.activityManager = activityManager;
        apis = new ArrayList<>();
        if (SdkUtil.isEclair()) {
            addEclairApis();
        }
    }

    @TargetApi(Build.VERSION_CODES.ECLAIR)
    private void addEclairApis() {
        int API_LEVEL = SdkUtil.eclair();
        apis.add(new StringApi(API_LEVEL, "memoryClass", activityManager.getMemoryClass() + " MiB"));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
