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
package info.trevortabaka.deviceinfo.classes;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class ActivityManager implements Class_ {
    private final android.app.ActivityManager activityManager;
    private final Collection<Api> apis = new ArrayList<>();

    @Inject
    public ActivityManager(android.app.ActivityManager activityManager) {
        this.activityManager = activityManager;
        ApiFactory.ApiClassFactory factory = ApiFactory.newInstance(activityManager.getClass());
        if (SdkUtil.IS_5_ECLAIR) addEclairApis(factory.withApi(SdkUtil.ECLAIR));
        if (SdkUtil.IS_11_HONEYCOMB) add11Apis(factory.withApi(SdkUtil.HONEYCOMB));
        if (SdkUtil.IS_19_KITKAT) add19Apis(factory.withApi(SdkUtil.KITKAT));
    }

    private void addEclairApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("getMemoryClass()").of(activityManager.getMemoryClass(), "MiB"));
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void add11Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("getLauncherLargeIconDensity()").of(activityManager.getLauncherLargeIconDensity(), "dpi"));
        apis.add(factory.withName("getLauncherLargeIconSize()").of(activityManager.getLauncherLargeIconSize(), "px"));
        apis.add(factory.withName("isRunningInTestHarness").of(android.app.ActivityManager.isRunningInTestHarness()));
    }

    @TargetApi(SdkUtil.KITKAT)
    private void add19Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("isLowRamDevice()").of(activityManager.isLowRamDevice()));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
