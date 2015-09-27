package info.trevortabaka.deviceinfo.honeycomb;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;

public class HoneycombApis implements ApiGroup {
    private ActivityManager activityManager;

    @Inject
    public HoneycombApis(ActivityManager activityManager) {
        this.activityManager = activityManager;
    }

    @Override
    public Collection<Api> apis() {
        return activityManager.apis();
    }
}
