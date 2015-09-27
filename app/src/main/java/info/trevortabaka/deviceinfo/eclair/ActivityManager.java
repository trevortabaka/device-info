package info.trevortabaka.deviceinfo.eclair;

import android.os.Build;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.util.CollectionUtil;

public class ActivityManager implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.ECLAIR;

    public final Api MEMORY_CLASS;

    @Inject
    public ActivityManager(ApiFactory apiFactory, android.app.ActivityManager activityManager) {
        MEMORY_CLASS = apiFactory.builder(API_LEVEL, "memoryClass").of(activityManager.getMemoryClass() + " MiB");
    }

    @Override
    public Collection<Api> apis() {
        return CollectionUtil.combine(MEMORY_CLASS);
    }
}
