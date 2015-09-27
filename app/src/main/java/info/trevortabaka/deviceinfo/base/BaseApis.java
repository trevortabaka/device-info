package info.trevortabaka.deviceinfo.base;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;
import info.trevortabaka.deviceinfo.util.CollectionUtil;

public class BaseApis implements ApiGroup {

    private final Configuration configuration;
    private final DisplayMetrics displayMetrics;
    private final BaseRuntime runtime;

    @Inject
    public BaseApis(Configuration configuration,
                    DisplayMetrics displayMetrics,
                    BaseRuntime runtime) {
        this.configuration = configuration;
        this.displayMetrics = displayMetrics;
        this.runtime = runtime;
    }

    @Override
    public Collection<Api> apis() {
        return CollectionUtil.combine(
                displayMetrics.apis(),
                configuration.apis(),
                runtime.apis());
    }

}
