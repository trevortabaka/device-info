package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.api.DensityDpiApi;
import info.trevortabaka.deviceinfo.api.FloatApi;
import info.trevortabaka.deviceinfo.api.PixelApi;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class DisplayMetrics implements Class_ {
    private final android.util.DisplayMetrics displayMetrics;
    private final Collection<Api> apis;

    @Inject
    public DisplayMetrics(android.util.DisplayMetrics displayMetrics) {
        this.displayMetrics = displayMetrics;
        apis = new ArrayList<>();
        if (SdkUtil.IS_BASE) addBaseApis();
        if (SdkUtil.IS_DONUT) addDonutApis();
    }

    @TargetApi(SdkUtil.BASE)
    private void addBaseApis() {
        int apiLevel = SdkUtil.BASE;
        apis.add(new FloatApi(apiLevel, "density", displayMetrics.density));
        apis.add(new PixelApi.Builder(apiLevel, "heightPixels").with(displayMetrics.heightPixels));
        apis.add(new FloatApi(apiLevel, "scaledDensity", displayMetrics.scaledDensity));
        apis.add(new PixelApi.Builder(apiLevel, "widthPixels").with(displayMetrics.widthPixels));
        apis.add(new PixelApi.Builder(apiLevel, "xdpi").with(displayMetrics.xdpi));
        apis.add(new PixelApi.Builder(apiLevel, "ydpi").with(displayMetrics.ydpi));
    }

    @TargetApi(SdkUtil.DONUT)
    private void addDonutApis() {
        int apiLevel = SdkUtil.DONUT;
        apis.add(new DensityDpiApi(apiLevel, "densityDpi", displayMetrics.densityDpi));
    }


    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
