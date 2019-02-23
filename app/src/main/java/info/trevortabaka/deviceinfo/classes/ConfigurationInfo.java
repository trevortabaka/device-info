package info.trevortabaka.deviceinfo.classes;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.util.SdkUtil;
import info.trevortabaka.deviceinfo.value.InputFeaturesValue;
import info.trevortabaka.deviceinfo.value.KeyboardValue;
import info.trevortabaka.deviceinfo.value.NavigationValue;
import info.trevortabaka.deviceinfo.value.TouchscreenValue;

public class ConfigurationInfo implements Class_ {
    private final android.content.pm.ConfigurationInfo configurationInfo;
    private final Collection<Api> apis;

    @Inject
    public ConfigurationInfo(android.content.pm.ConfigurationInfo configurationInfo) {
        this.configurationInfo = configurationInfo;
        this.apis = new ArrayList<>();
        ApiFactory.ApiClassFactory factory = ApiFactory.newInstance(configurationInfo.getClass());
        if (SdkUtil.IS_3_CUPCAKE) add3Apis(factory.withApi(SdkUtil.CUPCAKE));
        if (SdkUtil.IS_4_DONUT) add4Apis(factory.withApi(SdkUtil.DONUT));
    }

    private void add4Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("reqGlEsVersion").of(configurationInfo.reqGlEsVersion));
        apis.add(factory.withName("getGlEsVersion()").of(configurationInfo.getGlEsVersion()));
    }

    private void add3Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("reqInputFeatures").of(new InputFeaturesValue(configurationInfo)));
        apis.add(factory.withName("reqKeyboardType").of(new KeyboardValue(configurationInfo)));
        apis.add(factory.withName("reqNavigation").of(new NavigationValue(configurationInfo)));
        apis.add(factory.withName("reqTouchScreen").of(new TouchscreenValue(configurationInfo.reqTouchScreen)));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
