package info.trevortabaka.deviceinfo.api;

import javax.inject.Inject;

public class ApiFactory {

    @Inject
    public ApiFactory() {
    }

    public Builder builder(int apiLevel, String name) {
        return new Builder(apiLevel, name);
    }

    public static class Builder {
        private final int apiLevel;
        private final String name;

        public Builder(int apiLevel, String name) {
            this.apiLevel = apiLevel;
            this.name = name;
        }

        public AbstractApi of(int value) {
            return new GenericApi<>(apiLevel, name, value);
        }

        public AbstractApi of(float value) {
            return new GenericApi<>(apiLevel, name, value);
        }

        public AbstractApi of(boolean value) {
            return new GenericApi<>(apiLevel, name, value);
        }

        public AbstractApi of(String value) {
            return new GenericApi<>(apiLevel, name, value);
        }

        public AbstractApi ofPixels(int pixels) {
            return new GenericApi<>(apiLevel, name, pixels + " px");
        }

        public AbstractApi ofPixels(float pixels) {
            return new GenericApi<>(apiLevel, name, pixels + " px");
        }

        public AbstractApi ofMemory(long memory) {
            return new MemoryApi(apiLevel, name, memory);
        }
    }

}
