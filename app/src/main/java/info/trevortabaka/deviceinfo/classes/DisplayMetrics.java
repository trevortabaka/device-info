package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.DensityDpiApi;
import info.trevortabaka.deviceinfo.api.FloatApi;
import info.trevortabaka.deviceinfo.api.PixelApi;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class DisplayMetrics implements ApiGroup {
    private final android.util.DisplayMetrics displayMetrics;
    private final Collection<Api> apis;

    @Inject
    public DisplayMetrics(android.util.DisplayMetrics displayMetrics) {
        this.displayMetrics = displayMetrics;
        apis = new ArrayList<>();
        addBaseApis();
        if (SdkUtil.isDonut()) {
            addDonutApis();
        }
    }

    @TargetApi(Build.VERSION_CODES.BASE)
    private void addBaseApis() {
        int apiLevel = SdkUtil.base();
        apis.add(new FloatApi(apiLevel, "density", displayMetrics.density));
        apis.add(new PixelApi.Builder(apiLevel, "heightPixels").with(displayMetrics.heightPixels));
        apis.add(new FloatApi(apiLevel, "scaledDensity", displayMetrics.scaledDensity));
        apis.add(new PixelApi.Builder(apiLevel, "widthPixels").with(displayMetrics.widthPixels));
        apis.add(new PixelApi.Builder(apiLevel, "xdpi").with(displayMetrics.xdpi));
        apis.add(new PixelApi.Builder(apiLevel, "ydpi").with(displayMetrics.ydpi));
    }

    @TargetApi(Build.VERSION_CODES.DONUT)
    private void addDonutApis() {
        int apiLevel = SdkUtil.donut();
        apis.add(new DensityDpiApi(apiLevel, "densityDpi", displayMetrics.densityDpi));
    }


    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
