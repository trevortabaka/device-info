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
                return "DisplayMetrics.DENSITY_280";
            case android.util.DisplayMetrics.DENSITY_360:
                return "DisplayMetrics.DENSITY_360";
            case android.util.DisplayMetrics.DENSITY_400:
                return "DisplayMetrics.DENSITY_400";
            case android.util.DisplayMetrics.DENSITY_420:
                return "DisplayMetrics.DENSITY_420";
            case android.util.DisplayMetrics.DENSITY_560:
                return "DisplayMetrics.DENSITY_560";
            case android.util.DisplayMetrics.DENSITY_HIGH:
                return "DisplayMetrics.DENSITY_HIGH";
            case android.util.DisplayMetrics.DENSITY_LOW:
                return "DisplayMetrics.DENSITY_LOW";
            case android.util.DisplayMetrics.DENSITY_MEDIUM:
                // a.k.a. android.util.DisplayMetrics.DENSITY_DEFAULT:
                return "DisplayMetrics.DENSITY_MEDIUM";
            case android.util.DisplayMetrics.DENSITY_TV:
                return "DisplayMetrics.DENSITY_TV";
            case android.util.DisplayMetrics.DENSITY_XHIGH:
                return "DisplayMetrics.DENSITY_XHIGH";
            case android.util.DisplayMetrics.DENSITY_XXHIGH:
                return "DisplayMetrics.DENSITY_XXHIGH";
            case android.util.DisplayMetrics.DENSITY_XXXHIGH:
                return "DisplayMetrics.DENSITY_XXXHIGH";
            default:
                return null;
        }
    }

}
