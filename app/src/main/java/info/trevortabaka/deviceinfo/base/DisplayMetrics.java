package info.trevortabaka.deviceinfo.base;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.util.CollectionUtil;

@TargetApi(Build.VERSION_CODES.BASE)
public class DisplayMetrics implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.BASE;

    public final Api DENSITY;
    public final Api HEIGHT_PIXELS;
    public final Api SCALED_DENSITY;
    public final Api WIDTH_PIXELS;
    public final Api X_DPI;
    public final Api Y_DPI;

    @Inject
    public DisplayMetrics(ApiFactory apiFactory, android.util.DisplayMetrics displayMetrics) {
        DENSITY = apiFactory.builder(API_LEVEL, "density").of(displayMetrics.density);
        HEIGHT_PIXELS = apiFactory.builder(API_LEVEL, "heightPixels").ofPixels(displayMetrics.heightPixels);
        SCALED_DENSITY = apiFactory.builder(API_LEVEL, "scaledDensity").of(displayMetrics.scaledDensity);
        WIDTH_PIXELS = apiFactory.builder(API_LEVEL, "widthPixels").ofPixels(displayMetrics.widthPixels);
        X_DPI = apiFactory.builder(API_LEVEL, "xdpi").ofPixels(displayMetrics.xdpi);
        Y_DPI = apiFactory.builder(API_LEVEL, "ydpi").ofPixels(displayMetrics.ydpi);
    }

    @Override
    public Collection<Api> apis() {
        return CollectionUtil.combine(
                DENSITY,
                HEIGHT_PIXELS,
                SCALED_DENSITY,
                WIDTH_PIXELS,
                X_DPI,
                Y_DPI
        );
    }

}
