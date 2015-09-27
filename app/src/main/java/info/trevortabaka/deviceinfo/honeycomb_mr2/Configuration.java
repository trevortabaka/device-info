package info.trevortabaka.deviceinfo.honeycomb_mr2;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.util.CollectionUtil;

@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
public class Configuration implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.HONEYCOMB_MR2;

    public final Api SCREEN_HEIGHT_DP;
    public final Api SCREEN_WIDTH_DP;
    public final Api SMALLEST_SCREEN_WIDTH_DP;

    @Inject
    public Configuration(ApiFactory apiFactory, android.content.res.Configuration configuration) {
        SCREEN_HEIGHT_DP = apiFactory.builder(API_LEVEL, "screenHeightDp").of(configuration.screenHeightDp);
        SCREEN_WIDTH_DP = apiFactory.builder(API_LEVEL, "screenWidthDp").of(configuration.screenWidthDp);
        SMALLEST_SCREEN_WIDTH_DP = apiFactory.builder(API_LEVEL, "smallestScreenWidthDp").of(configuration.smallestScreenWidthDp);
    }

    @Override
    public Collection<Api> apis() {
        return CollectionUtil.combine(
                SCREEN_HEIGHT_DP,
                SCREEN_WIDTH_DP,
                SMALLEST_SCREEN_WIDTH_DP
        );
    }
}
