package info.trevortabaka.deviceinfo.base;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.util.CollectionUtil;

@TargetApi(Build.VERSION_CODES.BASE)
public class BaseRuntime implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.BASE;

    public final Api AVAILABLE_PROCESSORS;
    public final Api FREE_MEMORY;
    public final Api MAX_MEMORY;
    public final Api TOTAL_MEMORY;

    @Inject
    public BaseRuntime(ApiFactory apiFactory, java.lang.Runtime runtime) {
        AVAILABLE_PROCESSORS = apiFactory.builder(API_LEVEL, "availableProcessors").of(runtime.availableProcessors());
        FREE_MEMORY = apiFactory.builder(API_LEVEL, "freeMemory").ofMemory(runtime.freeMemory());
        MAX_MEMORY = apiFactory.builder(API_LEVEL, "totalMemory").ofMemory(runtime.maxMemory());
        TOTAL_MEMORY = apiFactory.builder(API_LEVEL, "totalMemory").ofMemory(runtime.totalMemory());
    }

    @Override
    public Collection<Api> apis() {
        return CollectionUtil.combine(
                AVAILABLE_PROCESSORS,
                FREE_MEMORY,
                MAX_MEMORY,
                TOTAL_MEMORY
        );
    }
}
