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
        Api of(boolean value);

        Api of(int value);

        Api of(float value);

        Api of(String value);

        Api of(ApiValue value);
    }

    private static class Builder implements ApiClassFactory {
        private final Class apiClass;

        public Builder(Class apiClass) {
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

        public Builder2(Class apiClass, int apiLevel) {
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

        public Builder3(Class apiClass, int apiLevel, String name) {
            this.apiClass = apiClass;
            this.apiLevel = apiLevel;
            this.name = name;
        }

        @Override
        public Api of(boolean value) {
            return new ApiImpl(apiClass, apiLevel, name, new StringValueOf<>(value));
        }

        @Override
        public Api of(int value) {
            return new ApiImpl(apiClass, apiLevel, name, new StringValueOf<>(value));
        }

        @Override
        public Api of(float value) {
            return new ApiImpl(apiClass, apiLevel, name, new StringValueOf<>(value));
        }

        @Override
        public Api of(String value) {
            return new ApiImpl(apiClass, apiLevel, name, new StringValueOf<>(value));
        }

        @Override
        public Api of(ApiValue value) {
            return new ApiImpl(apiClass, apiLevel, name, value);
        }
    }
}
