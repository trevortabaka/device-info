package info.trevortabaka.deviceinfo.value;

import android.content.pm.ConfigurationInfo;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class InputFeaturesValue implements ApiValue {
    private final int reqInputFeatures;

    public InputFeaturesValue(ConfigurationInfo configurationInfo) {
        reqInputFeatures = configurationInfo.reqInputFeatures;
    }

    @Override
    public String getValue() {
        return String.valueOf(reqInputFeatures);
    }

    @Override
    public String getHumanReadableValue() {
        switch (reqInputFeatures) {
            case ConfigurationInfo.INPUT_FEATURE_FIVE_WAY_NAV:
                return "INPUT_FEATURE_FIVE_WAY_NAV";
            case ConfigurationInfo.INPUT_FEATURE_HARD_KEYBOARD:
                return "INPUT_FEATURE_HARD_KEYBOARD";
            default:
                return null;
        }
    }
}
