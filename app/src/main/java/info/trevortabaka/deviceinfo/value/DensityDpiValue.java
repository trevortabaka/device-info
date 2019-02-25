/*
Copyright (C) 2019 Trevor Tabaka

This file is part of Device Info.

Device Info is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Device Info is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Device Info.  If not, see <https://www.gnu.org/licenses/>.
*/
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
