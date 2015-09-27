package info.trevortabaka.deviceinfo.base;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.util.MyCollections;

public class BaseApis implements ApiGroup {

    private final Configuration configuration;
    private final DisplayMetrics displayMetrics;
    private final Runtime_ runtime;

    @Inject
    public BaseApis(Configuration configuration,
                    DisplayMetrics displayMetrics,
                    Runtime_ runtime) {
        this.configuration = configuration;
        this.displayMetrics = displayMetrics;
        this.runtime = runtime;
    }

    @Override
    public Collection<Api> apis() {
        return MyCollections.list2(
                displayMetrics.apis(),
                configuration.apis(),
                runtime.apis());
    }

}
