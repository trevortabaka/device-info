package info.trevortabaka.deviceinfo.util;

import android.os.Build;

public class SdkUtil {
    public static final int BASE = Build.VERSION_CODES.BASE;
    public static final int BASE_1_1 = Build.VERSION_CODES.BASE_1_1;
    public static final int CUPCAKE = Build.VERSION_CODES.CUPCAKE;
    public static final int DONUT = Build.VERSION_CODES.DONUT;
    public static final int ECLAIR = Build.VERSION_CODES.ECLAIR;
    public static final int ECLAIR_0_1 = Build.VERSION_CODES.ECLAIR_0_1;
    public static final int ECLAIR_MR1 = Build.VERSION_CODES.ECLAIR_MR1;
    public static final int FROYO = Build.VERSION_CODES.FROYO;
    public static final int GINGERBREAD = Build.VERSION_CODES.GINGERBREAD;
    public static final int GINGERBREAD_MR1 = Build.VERSION_CODES.GINGERBREAD_MR1;
    public static final int HONEYCOMB = Build.VERSION_CODES.HONEYCOMB;
    public static final int HONEYCOMB_MR1 = Build.VERSION_CODES.HONEYCOMB_MR1;
    public static final int HONEYCOMB_MR2 = Build.VERSION_CODES.HONEYCOMB_MR2;
    public static final int ICE_CREAM_SANDWICH = Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    public static final int ICE_CREAM_SANDWICH_MR1 = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1;
    public static final int JELLY_BEAN = Build.VERSION_CODES.JELLY_BEAN;
    public static final int JELLY_BEAN_MR1 = Build.VERSION_CODES.JELLY_BEAN_MR1;
    public static final int JELLY_BEAN_MR2 = Build.VERSION_CODES.JELLY_BEAN_MR2;
    public static final int KITKAT = Build.VERSION_CODES.KITKAT;
    public static final int KITKAT_WATCH = Build.VERSION_CODES.KITKAT_WATCH;
    public static final int LOLLIPOP = Build.VERSION_CODES.LOLLIPOP;
    public static final int LOLLIPOP_MR1 = Build.VERSION_CODES.LOLLIPOP_MR1;
    public static final int MARSHMALLOW = Build.VERSION_CODES.M;

    public static final boolean IS_1_BASE = isSdk(BASE);
    public static final boolean IS_2_BASE_1_1 = isSdk(BASE_1_1);
    public static final boolean IS_3_CUPCAKE = isSdk(CUPCAKE);
    public static final boolean IS_4_DONUT = isSdk(DONUT);
    public static final boolean IS_5_ECLAIR = isSdk(ECLAIR);
    public static final boolean IS_6_ECLAIR_0_1 = isSdk(ECLAIR_0_1);
    public static final boolean IS_7_ECLAIR_MR1 = isSdk(ECLAIR_MR1);
    public static final boolean IS_8_FROYO = isSdk(FROYO);
    public static final boolean IS_9_GINGERBREAD = isSdk(GINGERBREAD);
    public static final boolean IS_10_GINGERBREAD_MR1 = isSdk(GINGERBREAD_MR1);
    public static final boolean IS_11_HONEYCOMB = isSdk(HONEYCOMB);
    public static final boolean IS_12_HONEYCOMB_MR1 = isSdk(HONEYCOMB_MR1);
    public static final boolean IS_13_HONEYCOMB_MR2 = isSdk(HONEYCOMB_MR2);
    public static final boolean IS_14_ICE_CREAM_SANDWICH = isSdk(ICE_CREAM_SANDWICH);
    public static final boolean IS_15_ICE_CREAM_SANDWICH_MR1 = isSdk(ICE_CREAM_SANDWICH_MR1);
    public static final boolean IS_16_JELLY_BEAN = isSdk(JELLY_BEAN);
    public static final boolean IS_17_JELLY_BEAN_MR1 = isSdk(JELLY_BEAN_MR1);
    public static final boolean IS_18_JELLY_BEAN_MR2 = isSdk(JELLY_BEAN_MR2);
    public static final boolean IS_19_KITKAT = isSdk(KITKAT);
    public static final boolean IS_20_KITKAT_WATCH = isSdk(KITKAT_WATCH);
    public static final boolean IS_21_LOLLIPOP = isSdk(LOLLIPOP);
    public static final boolean IS_22_LOLLIPOP_MR1 = isSdk(LOLLIPOP_MR1);
    public static final boolean IS_23_MARSHMALLOW = isSdk(MARSHMALLOW);

    private static boolean isSdk(int version) {
        return Build.VERSION.SDK_INT >= version;
    }

}
