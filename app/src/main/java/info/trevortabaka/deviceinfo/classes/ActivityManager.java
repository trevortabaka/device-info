package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class ActivityManager implements Class_ {
    private final android.app.ActivityManager activityManager;
    private final Collection<Api> apis;
    private final ApiFactory.ApiClassFactory factory;

    @Inject
    public ActivityManager(android.app.ActivityManager activityManager) {
        this.activityManager = activityManager;
        apis = new ArrayList<>();
        factory = ApiFactory.newInstance(activityManager.getClass());
        if (SdkUtil.IS_ECLAIR) addEclairApis();
    }

    @TargetApi(SdkUtil.ECLAIR)
    private void addEclairApis() {
        ApiFactory.ApiLevelFactory factory = this.factory.withApi(SdkUtil.ECLAIR);
        apis.add(factory.withName("memoryClass").of(activityManager.getMemoryClass() + " MiB"));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
