package info.trevortabaka.deviceinfo.api;

public abstract class PixelApi extends AbstractApi {

    abstract String getPixels();

    private PixelApi(int apiLevel, String name) {
        super(apiLevel, name);
    }

    @Override
    public String getValue() {
        return getPixels() + " px";
    }

    public static class Builder {
        private final int apiLevel;
        private final String name;

        public Builder(int apiLevel, String name) {
            this.apiLevel = apiLevel;
            this.name = name;
        }

        public PixelApi with(int pixels) {
            return new IntPixelApi(apiLevel, name, pixels);
        }

        public PixelApi with(float pixels) {
            return new FloatPixelApi(apiLevel, name, pixels);
        }
    }

    private static class IntPixelApi extends PixelApi {
        private final int pixels;

        @Override
        String getPixels() {
            return String.valueOf(pixels);
        }

        public IntPixelApi(int apiLevel, String name, int pixels) {
            super(apiLevel, name);
            this.pixels = pixels;
        }
    }

    private static class FloatPixelApi extends PixelApi {
        private final float pixels;

        @Override
        String getPixels() {
            return String.valueOf(pixels);
        }

        public FloatPixelApi(int apiLevel, String name, float pixels) {
            super(apiLevel, name);
            this.pixels = pixels;
        }
    }

}
