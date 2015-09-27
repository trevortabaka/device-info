package info.trevortabaka.deviceinfo.honeycomb_mr2;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;

public class HoneycombMR2Apis implements ApiGroup {
    private Configuration configuration;

    @Inject
    public HoneycombMR2Apis(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Collection<Api> apis() {
        return configuration.apis();
    }
}
