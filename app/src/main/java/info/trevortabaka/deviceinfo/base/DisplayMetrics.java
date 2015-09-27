package info.trevortabaka.deviceinfo.base;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.FloatApi;
import info.trevortabaka.deviceinfo.util.MyCollections;
import info.trevortabaka.deviceinfo.api.PixelApi;

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
    public DisplayMetrics(android.util.DisplayMetrics displayMetrics) {
        DENSITY = new FloatApi(API_LEVEL, "density", displayMetrics.density);
        HEIGHT_PIXELS = new PixelApi.Builder(API_LEVEL, "heightPixels").with(displayMetrics.heightPixels);
        SCALED_DENSITY = new FloatApi(API_LEVEL, "scaledDensity", displayMetrics.scaledDensity);
        WIDTH_PIXELS = new PixelApi.Builder(API_LEVEL, "widthPixels").with(displayMetrics.widthPixels);
        X_DPI = new PixelApi.Builder(API_LEVEL, "xdpi").with(displayMetrics.xdpi);
        Y_DPI = new PixelApi.Builder(API_LEVEL, "ydpi").with(displayMetrics.ydpi);
    }

    @Override
    public Collection<Api> apis() {
        return MyCollections.list(
                DENSITY,
                HEIGHT_PIXELS,
                SCALED_DENSITY,
                WIDTH_PIXELS,
                X_DPI,
                Y_DPI
        );
    }

}
