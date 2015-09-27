package info.trevortabaka.deviceinfo.eclair;

import android.os.Build;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.StringApi;
import info.trevortabaka.deviceinfo.util.MyCollections;

public class ActivityManager implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.ECLAIR;

    public final Api MEMORY_CLASS;

    @Inject
    public ActivityManager(android.app.ActivityManager activityManager) {
        MEMORY_CLASS = new StringApi(API_LEVEL, "memoryClass", activityManager.getMemoryClass() + " MiB");
    }

    @Override
    public Collection<Api> apis() {
        return MyCollections.list(MEMORY_CLASS);
    }
}
