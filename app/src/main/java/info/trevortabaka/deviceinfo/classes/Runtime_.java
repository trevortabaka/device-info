package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.value.MemoryValue;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class Runtime_ implements Class_ {
    private final java.lang.Runtime runtime;
    private final Collection<Api> apis;
    private final ApiFactory.ApiClassFactory factory;

    @Inject
    public Runtime_(java.lang.Runtime runtime) {
        this.runtime = runtime;
        apis = new ArrayList<>();
        factory = ApiFactory.newInstance(runtime.getClass());
        if (SdkUtil.IS_1_BASE) addBaseApis();
    }

    @TargetApi(SdkUtil.BASE)
    private void addBaseApis() {
        ApiFactory.ApiLevelFactory factory = this.factory.withApi(SdkUtil.BASE);
        apis.add(factory.withName("availableProcessors").of(runtime.availableProcessors()));
        apis.add(factory.withName("freeMemory").of(new MemoryValue(runtime.freeMemory())));
        apis.add(factory.withName("maxMemory").of(new MemoryValue(runtime.maxMemory())));
        apis.add(factory.withName("totalMemory").of(new MemoryValue(runtime.totalMemory())));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
