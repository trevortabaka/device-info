package info.trevortabaka.deviceinfo.api23;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.util.CollectionUtil;

@TargetApi(Build.VERSION_CODES.M)
public class Configuration implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.M;

    public final Api IS_SCREEN_ROUND;

    @Inject
    public Configuration(ApiFactory apiFactory, android.content.res.Configuration configuration) {
        IS_SCREEN_ROUND = apiFactory.builder(API_LEVEL, "isScreenRound").of(configuration.isScreenRound());
    }

    @Override
    public Collection<Api> apis() {
        return CollectionUtil.combine(IS_SCREEN_ROUND);
    }
}
