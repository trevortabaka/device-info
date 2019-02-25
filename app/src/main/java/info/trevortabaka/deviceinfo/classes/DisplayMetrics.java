package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.value.DensityDpiValue;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class DisplayMetrics implements Class_ {
    private final android.util.DisplayMetrics displayMetrics;
    private final Collection<Api> apis = new ArrayList<>();

    @Inject
    public DisplayMetrics(android.util.DisplayMetrics displayMetrics) {
        this.displayMetrics = displayMetrics;
        ApiFactory.ApiClassFactory factory = ApiFactory.newInstance(displayMetrics.getClass());
        if (SdkUtil.IS_1_BASE) addBaseApis(factory.withApi(SdkUtil.BASE));
        if (SdkUtil.IS_4_DONUT) addDonutApis(factory.withApi(SdkUtil.DONUT));
    }

    @TargetApi(SdkUtil.BASE)
    private void addBaseApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("density").of(displayMetrics.density));
        apis.add(factory.withName("heightPixels").of(displayMetrics.heightPixels, "px"));
        apis.add(factory.withName("scaledDensity").of(displayMetrics.scaledDensity));
        apis.add(factory.withName("widthPixels").of(displayMetrics.widthPixels, "px"));
        apis.add(factory.withName("xdpi").of(displayMetrics.xdpi, "px"));
        apis.add(factory.withName("ydpi").of(displayMetrics.ydpi, "px"));
    }

    @TargetApi(SdkUtil.DONUT)
    private void addDonutApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("densityDpi").of(new DensityDpiValue(displayMetrics)));
    }


    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
