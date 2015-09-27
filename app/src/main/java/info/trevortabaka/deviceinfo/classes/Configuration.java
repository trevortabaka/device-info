package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.BooleanApi;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.api.FloatApi;
import info.trevortabaka.deviceinfo.api.IntApi;
import info.trevortabaka.deviceinfo.api.OrientationApi;
import info.trevortabaka.deviceinfo.api.ScreenLayoutLongApi;
import info.trevortabaka.deviceinfo.api.ScreenLayoutSizeApi;
import info.trevortabaka.deviceinfo.api.StringApi;
import info.trevortabaka.deviceinfo.api.TouchscreenApi;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class Configuration implements Class_ {
    private final android.content.res.Configuration configuration;
    private final Collection<Api> apis;

    @Inject
    public Configuration(android.content.res.Configuration configuration) {
        this.configuration = configuration;
        apis = new ArrayList<>();
        if (SdkUtil.IS_BASE) addBaseApis();
        if (SdkUtil.IS_HONEYCOMB_MR2) addHoneycombMR2Apis();
        if (SdkUtil.IS_MARSHMALLOW) addMarshmallowApis();
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }

    @TargetApi(SdkUtil.BASE)
    private void addBaseApis() {
        int apiLevel = SdkUtil.BASE;
        apis.add(new FloatApi(apiLevel, "fontScale", configuration.fontScale));
        apis.add(new StringApi(apiLevel, "locale", configuration.locale.toString()));
        apis.add(new OrientationApi(apiLevel, "orientation", configuration.orientation));
        apis.add(new ScreenLayoutLongApi(apiLevel, "screenLayoutLong", configuration.screenLayout));
        apis.add(new ScreenLayoutSizeApi(apiLevel, "screenLayoutSize", configuration.screenLayout));
        apis.add(new TouchscreenApi(apiLevel, "touchscreen", configuration.touchscreen));
    }

    @TargetApi(SdkUtil.HONEYCOMB_MR2)
    private void addHoneycombMR2Apis() {
        int apiLevel = SdkUtil.HONEYCOMB_MR2;
        apis.add(new IntApi(apiLevel, "screenHeightDp", configuration.screenHeightDp));
        apis.add(new IntApi(apiLevel, "screenWidthDp", configuration.screenWidthDp));
        apis.add(new IntApi(apiLevel, "smallestScreenWidthDp", configuration.smallestScreenWidthDp));
    }

    @TargetApi(SdkUtil.MARSHMALLOW)
    private void addMarshmallowApis() {
        int apiLevel = SdkUtil.MARSHMALLOW;
        apis.add(new BooleanApi(apiLevel, "isScreenRound", configuration.isScreenRound()));
    }

}
