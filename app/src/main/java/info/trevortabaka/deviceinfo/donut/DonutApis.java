package info.trevortabaka.deviceinfo.donut;

import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiGroup;

public class DonutApis implements ApiGroup {
    private DisplayMetrics displayMetrics;

    @Inject
    public DonutApis(DisplayMetrics displayMetrics) {
        this.displayMetrics = displayMetrics;
    }

    @Override
    public Collection<Api> apis() {
        return displayMetrics.apis();
    }
}
