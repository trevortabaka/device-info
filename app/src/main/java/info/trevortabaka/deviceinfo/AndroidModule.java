package info.trevortabaka.deviceinfo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;

import dagger.Module;
import dagger.Provides;
import info.trevortabaka.deviceinfo.util.SdkUtil;

@Module
public class AndroidModule {
    private Activity context;

    public AndroidModule(Activity context) {
        this.context = context;
    }

    @Provides
    Configuration configuration() {
        return context.getResources().getConfiguration();
    }

    @Provides
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    DisplayMetrics displayMetrics() {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        Display defaultDisplay = context.getWindowManager().getDefaultDisplay();
        if (SdkUtil.IS_17_JELLY_BEAN_MR1) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    @Provides
    ActivityManager activityManager() {
        return (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
    }

    @Provides
    java.lang.Runtime runtime() {
        return java.lang.Runtime.getRuntime();
    }
}
