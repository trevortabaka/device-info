package info.trevortabaka.deviceinfo.util;

import android.os.Build;

public class SdkUtil {
    public static final int BASE = Build.VERSION_CODES.BASE;
    public static final int DONUT = Build.VERSION_CODES.DONUT;
    public static final int ECLAIR = Build.VERSION_CODES.ECLAIR;
    public static final int HONEYCOMB_MR2 = Build.VERSION_CODES.HONEYCOMB_MR2;
    public static final int MARSHMALLOW = Build.VERSION_CODES.M;
    public static final int JELLY_BEAN_MR1 = Build.VERSION_CODES.JELLY_BEAN_MR1;

    public static final boolean IS_BASE = isSdk(BASE);
    public static final boolean IS_DONUT = isSdk(DONUT);
    public static final boolean IS_ECLAIR = isSdk(ECLAIR);
    public static final boolean IS_HONEYCOMB_MR2 = isSdk(HONEYCOMB_MR2);
    public static final boolean IS_MARSHMALLOW = isSdk(MARSHMALLOW);
    public static final boolean IS_JELLY_BEAN_MR1 = isSdk(JELLY_BEAN_MR1);

    private static boolean isSdk(int version) {
        return Build.VERSION.SDK_INT >= version;
    }

}
