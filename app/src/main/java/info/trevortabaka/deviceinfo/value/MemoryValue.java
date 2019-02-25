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

public class MemoryValue implements ApiValue {
    private final long memory;

    public MemoryValue(long memory) {
        this.memory = memory;
    }

    @Override
    public String getValue() {
        return String.valueOf(memory);
    }

    @Override
    public String getHumanReadableValue() {
        long kibibytes = memory / 1024;
        long mibibytes = kibibytes / 1024;
        return mibibytes + " MiB";
    }
}
