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