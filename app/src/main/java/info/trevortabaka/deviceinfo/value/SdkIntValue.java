package info.trevortabaka.deviceinfo.value;

import android.support.annotation.Nullable;

import info.trevortabaka.deviceinfo.api.ApiValue;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class SdkIntValue implements ApiValue {
    private final int sdkInt;

    public SdkIntValue(int sdkInt) {
        this.sdkInt = sdkInt;
    }

    @Override
    public String getValue() {
        return String.valueOf(sdkInt);
    }

    @Nullable
    @Override
    public String getHumanReadableValue() {
        switch (sdkInt) {
            case SdkUtil.BASE:
                return "BASE";
            case SdkUtil.BASE_1_1:
                return "BASE_1_1";
            case SdkUtil.CUPCAKE:
                return "CUPCAKE";
            case SdkUtil.DONUT:
                return "DONUT";
            case SdkUtil.ECLAIR:
                return "ECLAIR";
            case SdkUtil.ECLAIR_0_1:
                return "ECLAIR_0_1";
            case SdkUtil.ECLAIR_MR1:
                return "ECLAIR_MR1";
            case SdkUtil.FROYO:
                return "FROYO";
            case SdkUtil.GINGERBREAD:
                return "GINGERBREAD";
            case SdkUtil.GINGERBREAD_MR1:
                return "GINGERBREAD_MR1";
            case SdkUtil.HONEYCOMB:
                return "HONEYCOMB";
            case SdkUtil.HONEYCOMB_MR1:
                return "HONEYCOMB_MR1";
            case SdkUtil.HONEYCOMB_MR2:
                return "HONEYCOMB_MR2";
            case SdkUtil.ICE_CREAM_SANDWICH:
                return "ICE_CREAM_SANDWICH";
            case SdkUtil.ICE_CREAM_SANDWICH_MR1:
                return "ICE_CREAM_SANDWICH_MR1";
            case SdkUtil.JELLY_BEAN:
                return "JELLY_BEAN";
            case SdkUtil.JELLY_BEAN_MR1:
                return "JELLY_BEAN_MR1";
            case SdkUtil.JELLY_BEAN_MR2:
                return "JELLY_BEAN_MR2";
            case SdkUtil.KITKAT:
                return "KITKAT";
            case SdkUtil.KITKAT_WATCH:
                return "KITKAT_WATCH";
            case SdkUtil.LOLLIPOP:
                return "LOLLIPOP";
            case SdkUtil.LOLLIPOP_MR1:
                return "LOLLIPOP_MR1";
            case SdkUtil.MARSHMALLOW:
                return "MARSHMALLOW";
            default:
                return null;
        }
    }
}
