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

import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class NavigationValue implements ApiValue {
    private final int reqNavigation;

    public NavigationValue(ConfigurationInfo configurationInfo) {
        reqNavigation = configurationInfo.reqNavigation;
    }

    @Override
    public String getValue() {
        return String.valueOf(reqNavigation);
    }

    @Override
    public String getHumanReadableValue() {
        switch (reqNavigation) {
            case Configuration.NAVIGATION_DPAD:
                return "NAVIGATION_DPAD";
            case Configuration.NAVIGATION_NONAV:
                return "NAVIGATION_NONAV";
            case Configuration.NAVIGATION_TRACKBALL:
                return "NAVIGATION_TRACKBALL";
            case Configuration.NAVIGATION_UNDEFINED:
                return "NAVIGATION_UNDEFINED";
            case Configuration.NAVIGATION_WHEEL:
                return "NAVIGATION_WHEEL";
            default:
                return null;
        }
    }
}
