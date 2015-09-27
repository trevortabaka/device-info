package info.trevortabaka.deviceinfo.api23;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.BooleanApi;
import info.trevortabaka.deviceinfo.util.MyCollections;

@TargetApi(Build.VERSION_CODES.M)
public class Configuration implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.M;

    public final Api IS_SCREEN_ROUND;

    @Inject
    public Configuration(android.content.res.Configuration configuration) {
        IS_SCREEN_ROUND = new BooleanApi(API_LEVEL, "isScreenRound", configuration.isScreenRound());
    }

    @Override
    public Collection<Api> apis() {
        return MyCollections.list(IS_SCREEN_ROUND);
    }
}
