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

public class ScreenLayoutLongValue implements ApiValue {
    private final int screenLayoutLong;

    public ScreenLayoutLongValue(Configuration configuration) {
        screenLayoutLong = configuration.screenLayout & android.content.res.Configuration.SCREENLAYOUT_LONG_MASK;
    }

    @Override
    public String getValue() {
        return String.valueOf(screenLayoutLong);
    }

    @Override
    public String getHumanReadableValue() {
        switch (screenLayoutLong) {
            case android.content.res.Configuration.SCREENLAYOUT_LONG_NO:
                return "SCREENLAYOUT_LONG_NO";
            case android.content.res.Configuration.SCREENLAYOUT_LONG_UNDEFINED:
                return "SCREENLAYOUT_LONG_UNDEFINED";
            case android.content.res.Configuration.SCREENLAYOUT_LONG_YES:
                return "SCREENLAYOUT_LONG_YES";
            default:
                return null;
        }
    }
}
