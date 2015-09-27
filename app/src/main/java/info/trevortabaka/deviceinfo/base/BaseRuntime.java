package info.trevortabaka.deviceinfo.base;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.IntApi;
import info.trevortabaka.deviceinfo.api.MemoryApi;
import info.trevortabaka.deviceinfo.util.MyCollections;

@TargetApi(Build.VERSION_CODES.BASE)
public class BaseRuntime implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.BASE;

    public final Api AVAILABLE_PROCESSORS;
    public final Api FREE_MEMORY;
    public final Api MAX_MEMORY;
    public final Api TOTAL_MEMORY;

    @Inject
    public BaseRuntime(java.lang.Runtime runtime) {
        AVAILABLE_PROCESSORS = new IntApi(API_LEVEL, "availableProcessors", runtime.availableProcessors());
        FREE_MEMORY = new MemoryApi(API_LEVEL, "freeMemory", runtime.freeMemory());
        MAX_MEMORY = new MemoryApi(API_LEVEL, "totalMemory", runtime.maxMemory());
        TOTAL_MEMORY = new MemoryApi(API_LEVEL, "totalMemory", runtime.totalMemory());
    }

    @Override
    public Collection<Api> apis() {
        return MyCollections.list(
                AVAILABLE_PROCESSORS,
                FREE_MEMORY,
                MAX_MEMORY,
                TOTAL_MEMORY
        );
    }
}
