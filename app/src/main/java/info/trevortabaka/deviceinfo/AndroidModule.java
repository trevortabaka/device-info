/*
Copyright (C) 2019 Trevor Tabaka

This file is part of Device Info.

Device Info is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Device Info is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Device Info.  If not, see <https://www.gnu.org/licenses/>.
*/
package info.trevortabaka.deviceinfo;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;

import dagger.Module;
import dagger.Provides;
import info.trevortabaka.deviceinfo.util.SdkUtil;

@Module
public class AndroidModule {
    private final Activity context;

    public AndroidModule(Activity context) {
        this.context = context;
    }

    @Provides
    Configuration configuration() {
        return context.getResources().getConfiguration();
    }

    @Provides
    ConfigurationInfo configurationInfo(ActivityManager activityManager) {
        return activityManager.getDeviceConfigurationInfo();
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
