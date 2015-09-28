package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.util.SdkUtil;
import info.trevortabaka.deviceinfo.value.OrientationValue;
import info.trevortabaka.deviceinfo.value.ScreenLayoutLongValue;
import info.trevortabaka.deviceinfo.value.ScreenLayoutSizeValue;
import info.trevortabaka.deviceinfo.value.TouchscreenValue;

public class Configuration implements Class_ {
    private final android.content.res.Configuration configuration;
    private final Collection<Api> apis;

    @Inject
    public Configuration(android.content.res.Configuration configuration) {
        this.configuration = configuration;
        apis = new ArrayList<>();
        ApiFactory.ApiClassFactory factory = ApiFactory.newInstance(configuration.getClass());
        if (SdkUtil.IS_1_BASE) addBaseApis(factory.withApi(SdkUtil.BASE));
        if (SdkUtil.IS_13_HONEYCOMB_MR2) addHoneycombMR2Apis(factory.withApi(SdkUtil.HONEYCOMB_MR2));
        if (SdkUtil.IS_23_MARSHMALLOW) addMarshmallowApis(factory.withApi(SdkUtil.MARSHMALLOW));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }

    @TargetApi(SdkUtil.BASE)
    private void addBaseApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("fontScale").of(configuration.fontScale));
        apis.add(factory.withName("locale").of(configuration.locale.toString()));
        apis.add(factory.withName("orientation").of(new OrientationValue(configuration)));
        apis.add(factory.withName("screenLayout (long)").of(new ScreenLayoutLongValue(configuration)));
        apis.add(factory.withName("screenLayout (size)").of(new ScreenLayoutSizeValue(configuration)));
        apis.add(factory.withName("touchscreen").of(new TouchscreenValue(configuration.touchscreen)));
    }

    @TargetApi(SdkUtil.HONEYCOMB_MR2)
    private void addHoneycombMR2Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("screenHeightDp").of(configuration.screenHeightDp, "dp"));
        apis.add(factory.withName("screenWidthDp").of(configuration.screenWidthDp, "dp"));
        apis.add(factory.withName("smallestScreenWidthDp").of(configuration.smallestScreenWidthDp, "dp"));
    }

    @TargetApi(SdkUtil.MARSHMALLOW)
    private void addMarshmallowApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("isScreenRound()").of(configuration.isScreenRound()));
    }

}
