package info.trevortabaka.deviceinfo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

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
        // TODO different display metrics for API 17
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
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
