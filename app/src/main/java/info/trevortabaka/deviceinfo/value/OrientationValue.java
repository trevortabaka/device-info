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

public class OrientationValue implements ApiValue {
    private final int orientation;

    public OrientationValue(Configuration configuration) {
        this.orientation = configuration.orientation;
    }

    @Override
    public String getValue() {
        return String.valueOf(orientation);
    }

    @Override
    public String getHumanReadableValue() {
        switch (orientation) {
            case android.content.res.Configuration.ORIENTATION_LANDSCAPE:
                return "ORIENTATION_LANDSCAPE";
            case android.content.res.Configuration.ORIENTATION_PORTRAIT:
                return "ORIENTATION_PORTRAIT";
            case android.content.res.Configuration.ORIENTATION_SQUARE:
                return "ORIENTATION_SQUARE";
            case android.content.res.Configuration.ORIENTATION_UNDEFINED:
                return "ORIENTATION_UNDEFINED";
            default:
                return null;
        }
    }
}
