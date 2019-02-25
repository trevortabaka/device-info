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

import android.content.res.Configuration;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class ScreenLayoutSizeValue implements ApiValue {
    private final int screenLayoutSize;

    public ScreenLayoutSizeValue(Configuration configuration) {
        screenLayoutSize = configuration.screenLayout & android.content.res.Configuration.SCREENLAYOUT_SIZE_MASK;
    }

    @Override
    public String getValue() {
        return String.valueOf(screenLayoutSize);
    }

    @Override
    public String getHumanReadableValue() {
        switch (screenLayoutSize) {
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_LARGE:
                return "SCREENLAYOUT_SIZE_LARGE";
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_NORMAL:
                return "SCREENLAYOUT_SIZE_NORMAL";
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_SMALL:
                return "SCREENLAYOUT_SIZE_SMALL";
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_UNDEFINED:
                return "SCREENLAYOUT_SIZE_UNDEFINED";
            case android.content.res.Configuration.SCREENLAYOUT_SIZE_XLARGE:
                return "SCREENLAYOUT_SIZE_XLARGE";
            default:
                return null;
        }
    }
}
