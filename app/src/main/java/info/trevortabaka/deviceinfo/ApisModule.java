package info.trevortabaka.deviceinfo;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.classes.Configuration;
import info.trevortabaka.deviceinfo.classes.DisplayMetrics;
import info.trevortabaka.deviceinfo.classes.Runtime_;
import info.trevortabaka.deviceinfo.classes.Build;

@Module(includes = AndroidModule.class)
public class ApisModule {

    @Provides
    List<Api> apis(Configuration configuration,
                   DisplayMetrics displayMetrics,
                   Runtime_ runtime,
                   Build build) {
        List<Api> apis = new ArrayList<>();
        apis.addAll(configuration.apis());
        apis.addAll(displayMetrics.apis());
        apis.addAll(runtime.apis());
        apis.addAll(build.apis());
        return apis;
    }

}