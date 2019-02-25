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

import info.trevortabaka.deviceinfo.api.ApiValue;

public class TouchscreenValue implements ApiValue {
    private final int touchscreen;

    public TouchscreenValue(int touchscreen) {
        this.touchscreen = touchscreen;
    }

    @Override
    public String getValue() {
        return String.valueOf(touchscreen);
    }

    @Override
    public String getHumanReadableValue() {
        switch (touchscreen) {
            case android.content.res.Configuration.TOUCHSCREEN_FINGER:
                return "TOUCHSCREEN_FINGER";
            case android.content.res.Configuration.TOUCHSCREEN_NOTOUCH:
                return "TOUCHSCREEN_NOTOUCH";
            case android.content.res.Configuration.TOUCHSCREEN_UNDEFINED:
                return "TOUCHSCREEN_UNDEFINED";
            case android.content.res.Configuration.TOUCHSCREEN_STYLUS:
                return "TOUCHSCREEN_STYLUS";
            default:
                return null;
        }
    }
}
