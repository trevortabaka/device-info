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

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.classes.ActivityManager;
import info.trevortabaka.deviceinfo.classes.Configuration;
import info.trevortabaka.deviceinfo.classes.ConfigurationInfo;
import info.trevortabaka.deviceinfo.classes.DisplayMetrics;
import info.trevortabaka.deviceinfo.classes.Runtime_;
import info.trevortabaka.deviceinfo.classes.Build;
import info.trevortabaka.deviceinfo.classes.VERSION;

@Module(includes = AndroidModule.class)
public class ApisModule {

    @Provides
    List<Api> apis(ActivityManager activityManager,
                   Configuration configuration,
                   ConfigurationInfo configurationInfo,
                   DisplayMetrics displayMetrics,
                   Runtime_ runtime,
                   Build build,
                   VERSION version) {
        List<Api> apis = new ArrayList<>();
        apis.addAll(activityManager.apis());
        apis.addAll(configuration.apis());
        apis.addAll(configurationInfo.apis());
        apis.addAll(displayMetrics.apis());
        apis.addAll(runtime.apis());
        apis.addAll(build.apis());
        apis.addAll(version.apis());
        return apis;
    }

}