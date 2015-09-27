package info.trevortabaka.deviceinfo.honeycomb_mr2;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.IntApi;
import info.trevortabaka.deviceinfo.util.MyCollections;

@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
public class Configuration implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.HONEYCOMB_MR2;

    public final Api SCREEN_HEIGHT_DP;
    public final Api SCREEN_WIDTH_DP;
    public final Api SMALLEST_SCREEN_WIDTH_DP;

    @Inject
    public Configuration(android.content.res.Configuration configuration) {
        SCREEN_HEIGHT_DP = new IntApi(API_LEVEL, "screenHeightDp", configuration.screenHeightDp);
        SCREEN_WIDTH_DP = new IntApi(API_LEVEL, "screenWidthDp", configuration.screenWidthDp);
        SMALLEST_SCREEN_WIDTH_DP = new IntApi(API_LEVEL, "smallestScreenWidthDp", configuration.smallestScreenWidthDp);
    }

    @Override
    public Collection<Api> apis() {
        return MyCollections.list(
                SCREEN_HEIGHT_DP,
                SCREEN_WIDTH_DP,
                SMALLEST_SCREEN_WIDTH_DP
        );
    }
}
