package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.value.OrientationValue;
import info.trevortabaka.deviceinfo.value.ScreenLayoutLongValue;
import info.trevortabaka.deviceinfo.value.ScreenLayoutSizeValue;
import info.trevortabaka.deviceinfo.value.TouchscreenValue;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class Configuration implements Class_ {
    private final android.content.res.Configuration configuration;
    private final Collection<Api> apis;
    private final ApiFactory.ApiClassFactory factory;

    @Inject
    public Configuration(android.content.res.Configuration configuration) {
        this.configuration = configuration;
        apis = new ArrayList<>();
        factory = ApiFactory.newInstance(configuration.getClass());
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
        ApiFactory.ApiLevelFactory factory = this.factory.withApi(SdkUtil.BASE);
        apis.add(factory.withName("fontScale").of(configuration.fontScale));
        apis.add(factory.withName("locale").of(configuration.locale.toString()));
        apis.add(factory.withName("orientation").of(new OrientationValue(configuration)));
        apis.add(factory.withName("screenLayoutLong").of(new ScreenLayoutLongValue(configuration)));
        apis.add(factory.withName("screenLayoutSize").of(new ScreenLayoutSizeValue(configuration)));
        apis.add(factory.withName("touchscreen").of(new TouchscreenValue(configuration)));
    }

    @TargetApi(SdkUtil.HONEYCOMB_MR2)
    private void addHoneycombMR2Apis() {
        ApiFactory.ApiLevelFactory factory = this.factory.withApi(SdkUtil.HONEYCOMB_MR2);
        apis.add(factory.withName("screenHeightDp").of(configuration.screenHeightDp));
        apis.add(factory.withName("screenWidthDp").of(configuration.screenWidthDp));
        apis.add(factory.withName("smallestScreenWidthDp").of(configuration.smallestScreenWidthDp));
    }

    @TargetApi(SdkUtil.MARSHMALLOW)
    private void addMarshmallowApis() {
        ApiFactory.ApiLevelFactory factory = this.factory.withApi(SdkUtil.MARSHMALLOW);
        apis.add(factory.withName("isScrenRound").of(configuration.isScreenRound()));
    }

}
