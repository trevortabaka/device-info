package info.trevortabaka.deviceinfo.honeycomb;

import android.os.Build;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.StringApi;
import info.trevortabaka.deviceinfo.util.MyCollections;

public class ActivityManager implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.HONEYCOMB;

    public final Api LARGE_MEMORY_CLASS;

    @Inject
    public ActivityManager(android.app.ActivityManager activityManager) {
        LARGE_MEMORY_CLASS = new StringApi(API_LEVEL, "largeMemoryClass", activityManager.getLargeMemoryClass() + " MiB");
    }

    @Override
    public Collection<Api> apis() {
        return MyCollections.list(LARGE_MEMORY_CLASS);
    }
}
