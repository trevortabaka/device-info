package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.BooleanApi;
import info.trevortabaka.deviceinfo.api.FloatApi;
import info.trevortabaka.deviceinfo.api.IntApi;
import info.trevortabaka.deviceinfo.api.OrientationApi;
import info.trevortabaka.deviceinfo.api.ScreenLayoutLongApi;
import info.trevortabaka.deviceinfo.api.ScreenLayoutSizeApi;
import info.trevortabaka.deviceinfo.api.StringApi;
import info.trevortabaka.deviceinfo.api.TouchscreenApi;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class Configuration implements ApiGroup {
    private final android.content.res.Configuration configuration;
    private final Collection<Api> apis;

    @Inject
    public Configuration(android.content.res.Configuration configuration) {
        this.configuration = configuration;
        apis = new ArrayList<>();
        addBaseApis();
        if (SdkUtil.isHoneycombMR2()) {
            addHoneycombMR2Apis();
        }
        if (SdkUtil.isMarshmallow()) {
            addMarshmallowApis();
        }
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }

    @TargetApi(Build.VERSION_CODES.BASE)
    private void addBaseApis() {
        int apiLevel = Build.VERSION_CODES.BASE;
        apis.add(new FloatApi(apiLevel, "fontScale", configuration.fontScale));
        apis.add(new StringApi(apiLevel, "locale", configuration.locale.toString()));
        apis.add(new OrientationApi(apiLevel, "orientation", configuration.orientation));
        apis.add(new ScreenLayoutLongApi(apiLevel, "screenLayoutLong", configuration.screenLayout));
        apis.add(new ScreenLayoutSizeApi(apiLevel, "screenLayoutSize", configuration.screenLayout));
        apis.add(new TouchscreenApi(apiLevel, "touchscreen", configuration.touchscreen));
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void addHoneycombMR2Apis() {
        int apiLevel = Build.VERSION_CODES.HONEYCOMB_MR2;
        apis.add(new IntApi(apiLevel, "screenHeightDp", configuration.screenHeightDp));
        apis.add(new IntApi(apiLevel, "screenWidthDp", configuration.screenWidthDp));
        apis.add(new IntApi(apiLevel, "smallestScreenWidthDp", configuration.smallestScreenWidthDp));
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void addMarshmallowApis() {
        int apiLevel = Build.VERSION_CODES.M;
        apis.add(new BooleanApi(apiLevel, "isScreenRound", configuration.isScreenRound()));
    }

}
