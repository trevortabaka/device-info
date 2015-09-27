package info.trevortabaka.deviceinfo.eclair;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;

public class EclairApis implements ApiGroup {
    private ActivityManager activityManager;

    @Inject
    public EclairApis(ActivityManager activityManager) {
        this.activityManager = activityManager;
    }

    @Override
    public Collection<Api> apis() {
        return activityManager.apis();
    }
}
