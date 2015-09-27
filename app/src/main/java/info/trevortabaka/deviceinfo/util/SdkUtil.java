package info.trevortabaka.deviceinfo.util;

import android.os.Build;

public class SdkUtil {

    public static boolean isHoneycombMR2() {
        return isSdk(Build.VERSION_CODES.HONEYCOMB_MR2);
    }

    public static boolean isMarshmallow() {
        return isSdk(Build.VERSION_CODES.M);
    }

    private static boolean isSdk(int version) {
        return Build.VERSION.SDK_INT >= version;
    }

    public static boolean isDonut() {
        return isSdk(Build.VERSION_CODES.DONUT);
    }

    public static int base() {
        return Build.VERSION_CODES.BASE;
    }

    public static int donut() {
        return Build.VERSION_CODES.DONUT;
    }

    public static int eclair() {
        return Build.VERSION_CODES.ECLAIR;
    }

    public static boolean isEclair() {
        return isSdk(Build.VERSION_CODES.ECLAIR);
    }
}
