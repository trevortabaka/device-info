package info.trevortabaka.deviceinfo.value;

import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class NavigationValue implements ApiValue {
    private final int reqNavigation;

    public NavigationValue(ConfigurationInfo configurationInfo) {
        reqNavigation = configurationInfo.reqNavigation;
    }

    @Override
    public String getValue() {
        return String.valueOf(reqNavigation);
    }

    @Override
    public String getHumanReadableValue() {
        switch (reqNavigation) {
            case Configuration.NAVIGATION_DPAD:
                return "NAVIGATION_DPAD";
            case Configuration.NAVIGATION_NONAV:
                return "NAVIGATION_NONAV";
            case Configuration.NAVIGATION_TRACKBALL:
                return "NAVIGATION_TRACKBALL";
            case Configuration.NAVIGATION_UNDEFINED:
                return "NAVIGATION_UNDEFINED";
            case Configuration.NAVIGATION_WHEEL:
                return "NAVIGATION_WHEEL";
            default:
                return null;
        }
    }
}
