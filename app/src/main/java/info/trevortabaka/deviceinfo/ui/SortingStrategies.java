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
package info.trevortabaka.deviceinfo.ui;

import java.util.Comparator;

import info.trevortabaka.deviceinfo.api.Api;

class SortingStrategies {
    static final Comparator<? super Api> API_LEVEL = new Comparator<Api>() {
        @Override
        public int compare(Api first, Api second) {
            int x = first.getApiLevel();
            int y = second.getApiLevel();
            return (x < y) ? -1 : ((x == y) ? 0 : 1);
        }
    };

    static final Comparator<? super Api> API_NAME = new Comparator<Api>() {
        @Override
        public int compare(Api first, Api second) {
            return first.getName().compareToIgnoreCase(second.getName());
        }
    };

    static final Comparator<? super Api> CLASS_NAME = new Comparator<Api>() {
        @Override
        public int compare(Api first, Api second) {
            return first.getClassName().compareToIgnoreCase(second.getClassName());
        }
    };
}
