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
package info.trevortabaka.deviceinfo.api;

import android.support.annotation.NonNull;

class ApiImpl implements Api {
    private final Class apiClass;
    private final int apiLevel;
    private final String name;
    private final ApiValue value;

    ApiImpl(Class apiClass, int apiLevel, String name, ApiValue value) {
        this.apiClass = apiClass;
        this.apiLevel = apiLevel;
        this.name = name;
        this.value = value;
    }

    @Override
    public int getApiLevel() {
        return apiLevel;
    }

    @Override
    public String getClassName() {
        return apiClass.getSimpleName();
    }

    @Override
    public String getPackageName() {
        Package apiClassPackage = apiClass.getPackage();
        return apiClassPackage != null ? apiClassPackage.getName() : "Unknown";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value.getValue();
    }

    @Override
    public String getHumanReadableValue() {
        return value.getHumanReadableValue();
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
