package info.trevortabaka.deviceinfo.api23;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;

public class Api23Apis implements ApiGroup {
    private Configuration configuration;

    @Inject
    public Api23Apis(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Collection<Api> apis() {
        return configuration.apis();
    }
}
