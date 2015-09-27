package info.trevortabaka.deviceinfo.base;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.AbstractHumanReadableApi;
import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.util.CollectionUtil;

@TargetApi(Build.VERSION_CODES.BASE)
public class Configuration implements ApiGroup {
    private static final int API_LEVEL = Build.VERSION_CODES.BASE;

    public final Api FONT_SCALE;
    public final Api LOCALE;
    public final Api ORIENTATION;
    public final Api SCREEN_LAYOUT_LONG;
    public final Api SCREEN_LAYOUT_SIZE;
    public final Api TOUCHSCREEN;

    @Inject
    public Configuration(ApiFactory apiFactory, android.content.res.Configuration configuration) {
        FONT_SCALE = apiFactory.builder(API_LEVEL, "fontScale").of(configuration.fontScale);
        LOCALE = apiFactory.builder(API_LEVEL, "locale").of(configuration.locale.toString());
        ORIENTATION = new OrientationApi(API_LEVEL, "orientation", configuration.orientation);
        SCREEN_LAYOUT_LONG = new ScreenLayoutLongApi(API_LEVEL, "screenLayoutLong", configuration.screenLayout);
        SCREEN_LAYOUT_SIZE = new ScreenLayoutSizeApi(API_LEVEL, "screenLayoutSize", configuration.screenLayout);
        TOUCHSCREEN = new TouchscreenApi(API_LEVEL, "touchscreen", configuration.touchscreen);
    }

    @Override
    public Collection<Api> apis() {
        return CollectionUtil.combine(
                FONT_SCALE,
                LOCALE,
                ORIENTATION,
                SCREEN_LAYOUT_LONG,
                SCREEN_LAYOUT_SIZE
        );
    }

    private class OrientationApi extends AbstractHumanReadableApi<Integer> {
        private final int orientation;

        public OrientationApi(int apiLevel, String name, int orientation) {
            super(apiLevel, name);
            this.orientation = orientation;
        }

        @NonNull
        @Override
        public Integer getRawValue() {
            return orientation;
        }

        @Override
        @Nullable
        public String getHumanReadableString() {
            switch (orientation) {
                case android.content.res.Configuration.ORIENTATION_LANDSCAPE:
                    return "Configuration.ORIENTATION_LANDSCAPE";
                case android.content.res.Configuration.ORIENTATION_PORTRAIT:
                    return "Configuration.ORIENTATION_PORTRAIT";
                case android.content.res.Configuration.ORIENTATION_SQUARE:
                    return "Configuration.ORIENTATION_SQUARE";
                case android.content.res.Configuration.ORIENTATION_UNDEFINED:
                    return "Configuration.ORIENTATION_UNDEFINED";
                default:
                    return null;
            }
        }
    }

    private class ScreenLayoutSizeApi extends AbstractHumanReadableApi<Integer> {
        private final int screenLayoutSize;

        public ScreenLayoutSizeApi(int apiLevel, String name, int screenLayout) {
            super(apiLevel, name);
            screenLayoutSize = screenLayout & android.content.res.Configuration.SCREENLAYOUT_SIZE_MASK;
        }

        @NonNull
        @Override
        public Integer getRawValue() {
            return screenLayoutSize;
        }

        @Nullable
        public String getHumanReadableString() {
            switch (screenLayoutSize) {
                case android.content.res.Configuration.SCREENLAYOUT_SIZE_LARGE:
                    return "Configuration.SCREENLAYOUT_SIZE_LARGE";
                case android.content.res.Configuration.SCREENLAYOUT_SIZE_NORMAL:
                    return "Configuration.SCREENLAYOUT_SIZE_NORMAL";
                case android.content.res.Configuration.SCREENLAYOUT_SIZE_SMALL:
                    return "Configuration.SCREENLAYOUT_SIZE_SMALL";
                case android.content.res.Configuration.SCREENLAYOUT_SIZE_UNDEFINED:
                    return "Configuration.SCREENLAYOUT_SIZE_UNDEFINED";
                case android.content.res.Configuration.SCREENLAYOUT_SIZE_XLARGE:
                    return "Configuration.SCREENLAYOUT_SIZE_XLARGE";
                default:
                    return null;
            }
        }
    }

    private class ScreenLayoutLongApi extends AbstractHumanReadableApi<Integer> {
        private final int screenLayoutLong;

        public ScreenLayoutLongApi(int apiLevel, String name, int screenLayout) {
            super(apiLevel, name);
            screenLayoutLong = screenLayout & android.content.res.Configuration.SCREENLAYOUT_LONG_MASK;
        }

        @NonNull
        @Override
        public Integer getRawValue() {
            return screenLayoutLong;
        }

        @Nullable
        public String getHumanReadableString() {
            switch (screenLayoutLong) {
                case android.content.res.Configuration.SCREENLAYOUT_LONG_NO:
                    return "Configuration.SCREENLAYOUT_LONG_NO";
                case android.content.res.Configuration.SCREENLAYOUT_LONG_UNDEFINED:
                    return "Configuration.SCREENLAYOUT_LONG_UNDEFINED";
                case android.content.res.Configuration.SCREENLAYOUT_LONG_YES:
                    return "Configuration.SCREENLAYOUT_LONG_YES";
                default:
                    return null;
            }
        }
    }

    private class TouchscreenApi extends AbstractHumanReadableApi<Integer> {
        private final int touchscreen;

        public TouchscreenApi(int apiLevel, String name, int touchscreen) {
            super(apiLevel, name);
            this.touchscreen = touchscreen;
        }

        @NonNull
        @Override
        public Integer getRawValue() {
            return touchscreen;
        }

        @Nullable
        public String getHumanReadableString() {
            switch (touchscreen) {
                case android.content.res.Configuration.TOUCHSCREEN_FINGER:
                    return "Configuration.TOUCHSCREEN_FINGER";
                case android.content.res.Configuration.TOUCHSCREEN_NOTOUCH:
                    return "Configuration.TOUCHSCREEN_NOTOUCH";
                case android.content.res.Configuration.TOUCHSCREEN_UNDEFINED:
                    return "Configuration.TOUCHSCREEN_UNDEFINED";
                case android.content.res.Configuration.TOUCHSCREEN_STYLUS:
                    return "Configuration.TOUCHSCREEN_STYLUS";
                default:
                    return null;
            }
        }
    }
}
