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

public class ApiFactory {

    public static ApiClassFactory newInstance(Class apiClass) {
        return new Builder(apiClass);
    }

    public interface ApiClassFactory {
        ApiLevelFactory withApi(int apiLevel);
    }

    public interface ApiLevelFactory {
        ApiNameFactory withName(String name);
    }

    public interface ApiNameFactory {
        Api of(ApiValue value);

        <T> Api of(T value);

        <T> Api of(T value, String unit);
    }

    private static class Builder implements ApiClassFactory {
        private final Class apiClass;

        Builder(Class apiClass) {
            this.apiClass = apiClass;
        }

        @Override
        public ApiLevelFactory withApi(int apiLevel) {
            return new Builder2(apiClass, apiLevel);
        }

    }

    private static class Builder2 implements ApiLevelFactory {
        private final Class apiClass;
        private final int apiLevel;

        Builder2(Class apiClass, int apiLevel) {
            this.apiClass = apiClass;
            this.apiLevel = apiLevel;
        }

        @Override
        public ApiNameFactory withName(String name) {
            return new Builder3(apiClass, apiLevel, name);
        }

    }

    private static class Builder3 implements ApiNameFactory {
        private final Class apiClass;
        private final int apiLevel;
        private final String name;

        Builder3(Class apiClass, int apiLevel, String name) {
            this.apiClass = apiClass;
            this.apiLevel = apiLevel;
            this.name = name;
        }

        @Override
        public Api of(ApiValue value) {
            return new ApiImpl(apiClass, apiLevel, name, value);
        }

        @Override
        public <T> Api of(T value) {
            return new ApiImpl(apiClass, apiLevel, name, new StringValue<>(value));
        }

        @Override
        public <T> Api of(T value, String unit) {
            return new ApiImpl(apiClass, apiLevel, name, new UnitValue<>(value, unit));
        }
    }
}
