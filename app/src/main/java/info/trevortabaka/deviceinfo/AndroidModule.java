package info.trevortabaka.deviceinfo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;

import dagger.Module;
import dagger.Provides;

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
    DisplayMetrics displayMetrics() {
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        Display defaultDisplay = context.getWindowManager().getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
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
    Runtime runtime() {
        return Runtime.getRuntime();
    }
}
