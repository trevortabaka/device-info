package info.trevortabaka.deviceinfo.honeycomb;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.util.CollectionUtil;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ActivityManager implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.HONEYCOMB;

    public final Api LARGE_MEMORY_CLASS;

    @Inject
    public ActivityManager(ApiFactory apiFactory, android.app.ActivityManager activityManager) {
        LARGE_MEMORY_CLASS = apiFactory.builder(API_LEVEL, "largeMemoryClass").of(activityManager.getLargeMemoryClass() + " MiB");
    }

    @Override
    public Collection<Api> apis() {
        return CollectionUtil.combine(LARGE_MEMORY_CLASS);
    }
}
