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

import android.support.annotation.Nullable;

import java.util.Arrays;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class StringArrayValue implements ApiValue {
    private final String[] values;

    public StringArrayValue(String[] values) {
        this.values = values;
    }

    @Override
    public String getValue() {
        return Arrays.toString(values);
    }

    @Nullable
    @Override
    public String getHumanReadableValue() {
        return getValue();
    }
}
