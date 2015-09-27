package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.api.IntApi;
import info.trevortabaka.deviceinfo.api.MemoryApi;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class Runtime_ implements Class_ {
    private final java.lang.Runtime runtime;
    private final Collection<Api> apis;

    @Inject
    public Runtime_(java.lang.Runtime runtime) {
        this.runtime = runtime;
        apis = new ArrayList<>();
        if (SdkUtil.IS_BASE) addBaseApis();
    }

    @TargetApi(SdkUtil.BASE)
    private void addBaseApis() {
        int API_LEVEL = SdkUtil.BASE;
        apis.add(new IntApi(API_LEVEL, "availableProcessors", runtime.availableProcessors()));
        apis.add(new MemoryApi(API_LEVEL, "freeMemory", runtime.freeMemory()));
        apis.add(new MemoryApi(API_LEVEL, "totalMemory", runtime.maxMemory()));
        apis.add(new MemoryApi(API_LEVEL, "totalMemory", runtime.totalMemory()));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
