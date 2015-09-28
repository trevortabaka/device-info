package info.trevortabaka.deviceinfo.value;

import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;

import info.trevortabaka.deviceinfo.api.ApiValue;

public class KeyboardValue implements ApiValue {
    private final int reqKeyboardType;

    public KeyboardValue(ConfigurationInfo configurationInfo) {
        reqKeyboardType = configurationInfo.reqKeyboardType;
    }

    @Override
    public String getValue() {
        return String.valueOf(reqKeyboardType);
    }

    @Override
    public String getHumanReadableValue() {
        switch (reqKeyboardType) {
            case Configuration.KEYBOARD_12KEY:
                return "KEYBOARD_12KEY";
            case Configuration.KEYBOARD_NOKEYS:
                return "KEYBOARD_NOKEYS";
            case Configuration.KEYBOARD_QWERTY:
                return "KEYBOARD_QWERTY";
            case Configuration.KEYBOARD_UNDEFINED:
                return "KEYBOARD_UNDEFINED";
            default:
                return null;
        }
    }
}
