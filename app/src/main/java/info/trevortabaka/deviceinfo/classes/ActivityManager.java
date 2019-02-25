package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class ActivityManager implements Class_ {
    private final android.app.ActivityManager activityManager;
    private final Collection<Api> apis = new ArrayList<>();

    @Inject
    public ActivityManager(android.app.ActivityManager activityManager) {
        this.activityManager = activityManager;
        ApiFactory.ApiClassFactory factory = ApiFactory.newInstance(activityManager.getClass());
        if (SdkUtil.IS_5_ECLAIR) addEclairApis(factory.withApi(SdkUtil.ECLAIR));
        if (SdkUtil.IS_11_HONEYCOMB) add11Apis(factory.withApi(SdkUtil.HONEYCOMB));
        if (SdkUtil.IS_19_KITKAT) add19Apis(factory.withApi(SdkUtil.KITKAT));
    }

    private void addEclairApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("getMemoryClass()").of(activityManager.getMemoryClass(), "MiB"));
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void add11Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("getLauncherLargeIconDensity()").of(activityManager.getLauncherLargeIconDensity(), "dpi"));
        apis.add(factory.withName("getLauncherLargeIconSize()").of(activityManager.getLauncherLargeIconSize(), "px"));
        apis.add(factory.withName("isRunningInTestHarness").of(android.app.ActivityManager.isRunningInTestHarness()));
    }

    @TargetApi(SdkUtil.KITKAT)
    private void add19Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("isLowRamDevice()").of(activityManager.isLowRamDevice()));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
