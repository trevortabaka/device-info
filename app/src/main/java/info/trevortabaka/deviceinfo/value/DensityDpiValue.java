package info.trevortabaka.deviceinfo.value;

import android.util.DisplayMetrics;

import info.trevortabaka.deviceinfo.api.ApiValue;

public final class DensityDpiValue implements ApiValue {
    private final int densityDpi;

    public DensityDpiValue(DisplayMetrics displayMetrics) {
        densityDpi = displayMetrics.densityDpi;
    }

    @Override
    public String getValue() {
        return String.valueOf(densityDpi);
    }

    @Override
    public String getHumanReadableValue() {
        switch (densityDpi) {
            case android.util.DisplayMetrics.DENSITY_280:
                return "DENSITY_280";
            case android.util.DisplayMetrics.DENSITY_360:
                return "DENSITY_360";
            case android.util.DisplayMetrics.DENSITY_400:
                return "DENSITY_400";
            case android.util.DisplayMetrics.DENSITY_420:
                return "DENSITY_420";
            case android.util.DisplayMetrics.DENSITY_560:
                return "DENSITY_560";
            case android.util.DisplayMetrics.DENSITY_HIGH:
                return "DENSITY_HIGH";
            case android.util.DisplayMetrics.DENSITY_LOW:
                return "DENSITY_LOW";
            case android.util.DisplayMetrics.DENSITY_MEDIUM:
                // a.k.a. android.util.DisplayMetrics.DENSITY_DEFAULT:
                return "DENSITY_MEDIUM";
            case android.util.DisplayMetrics.DENSITY_TV:
                return "DENSITY_TV";
            case android.util.DisplayMetrics.DENSITY_XHIGH:
                return "DENSITY_XHIGH";
            case android.util.DisplayMetrics.DENSITY_XXHIGH:
                return "DENSITY_XXHIGH";
            case android.util.DisplayMetrics.DENSITY_XXXHIGH:
                return "DENSITY_XXXHIGH";
            default:
                return null;
        }
    }

}
