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

import info.trevortabaka.deviceinfo.api.ApiValue;

public class InputFeaturesValue implements ApiValue {
    private final int reqInputFeatures;

    public InputFeaturesValue(ConfigurationInfo configurationInfo) {
        reqInputFeatures = configurationInfo.reqInputFeatures;
    }

    @Override
    public String getValue() {
        return String.valueOf(reqInputFeatures);
    }

    @Override
    public String getHumanReadableValue() {
        switch (reqInputFeatures) {
            case ConfigurationInfo.INPUT_FEATURE_FIVE_WAY_NAV:
                return "INPUT_FEATURE_FIVE_WAY_NAV";
            case ConfigurationInfo.INPUT_FEATURE_HARD_KEYBOARD:
                return "INPUT_FEATURE_HARD_KEYBOARD";
            default:
                return null;
        }
    }
}
