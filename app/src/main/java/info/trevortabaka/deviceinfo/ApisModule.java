package info.trevortabaka.deviceinfo;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;

import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api23.Api23Apis;
import info.trevortabaka.deviceinfo.base.BaseApis;
import info.trevortabaka.deviceinfo.donut.DonutApis;
import info.trevortabaka.deviceinfo.eclair.EclairApis;
import info.trevortabaka.deviceinfo.honeycomb.HoneycombApis;
import info.trevortabaka.deviceinfo.honeycomb_mr2.HoneycombMR2Apis;

import static android.os.Build.VERSION_CODES.*;

@Module(includes = AndroidModule.class)
public class ApisModule {

    @Provides
    List<Api> apis(BaseApis baseApis,
                   Lazy<DonutApis> donutApis,
                   Lazy<EclairApis> eclairApis,
                   Lazy<HoneycombApis> honeycombApis,
                   Lazy<HoneycombMR2Apis> honeycombMR2Apis,
                   Lazy<Api23Apis> api23Apis) {
        List<Api> apis = new ArrayList<>(baseApis.apis());

        if (isApi(DONUT)) {
            apis.addAll(donutApis.get().apis());
        }
        if (isApi(ECLAIR)) {
            apis.addAll(eclairApis.get().apis());
        }
        if (isApi(HONEYCOMB)) {
            apis.addAll(honeycombApis.get().apis());
        }
        if (isApi(HONEYCOMB_MR2)) {
            apis.addAll(honeycombMR2Apis.get().apis());
        }
        if (isApi(M)) {
            apis.addAll(api23Apis.get().apis());
        }

        return apis;
    }

    private boolean isApi(int version) {
        return Build.VERSION.SDK_INT >= version;
    }
}
