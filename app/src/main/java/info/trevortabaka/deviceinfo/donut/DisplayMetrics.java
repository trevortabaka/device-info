package info.trevortabaka.deviceinfo.donut;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.Nullable;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.AbstractApi;
import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.util.CollectionUtil;

@TargetApi(Build.VERSION_CODES.DONUT)
public class DisplayMetrics implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.DONUT;

    public final Api DENSITY_DPI;

    @Inject
    public DisplayMetrics(android.util.DisplayMetrics displayMetrics) {
        DENSITY_DPI = new DensityDpi(API_LEVEL, "densityDpi", displayMetrics.densityDpi);
    }

    @Override
    public Collection<Api> apis() {
        return CollectionUtil.combine(DENSITY_DPI);
    }

    public static final class DensityDpi extends AbstractApi {
        private final int densityDpi;

        public DensityDpi(int apiLevel, String name, int densityDpi) {
            super(apiLevel, name);
            this.densityDpi = densityDpi;
        }

        @Override
        public String getValue() {
            String humanReadable = getHumanReadableString(densityDpi);

            if (humanReadable == null) {
                return String.valueOf(densityDpi);
            } else {
                return humanReadable + " (" + densityDpi + ")";
            }
        }

        @Nullable
        private String getHumanReadableString(int rawValue) {
            switch (rawValue) {
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

}
