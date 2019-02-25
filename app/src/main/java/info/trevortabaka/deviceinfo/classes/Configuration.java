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

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.util.SdkUtil;
import info.trevortabaka.deviceinfo.value.OrientationValue;
import info.trevortabaka.deviceinfo.value.ScreenLayoutLongValue;
import info.trevortabaka.deviceinfo.value.ScreenLayoutSizeValue;
import info.trevortabaka.deviceinfo.value.TouchscreenValue;

public class Configuration implements Class_ {
    private final android.content.res.Configuration configuration;
    private final Collection<Api> apis = new ArrayList<>();

    @Inject
    public Configuration(android.content.res.Configuration configuration) {
        this.configuration = configuration;
        ApiFactory.ApiClassFactory factory = ApiFactory.newInstance(configuration.getClass());
        if (SdkUtil.IS_1_BASE) addBaseApis(factory.withApi(SdkUtil.BASE));
        if (SdkUtil.IS_13_HONEYCOMB_MR2) addHoneycombMR2Apis(factory.withApi(SdkUtil.HONEYCOMB_MR2));
        if (SdkUtil.IS_23_MARSHMALLOW) addMarshmallowApis(factory.withApi(SdkUtil.MARSHMALLOW));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }

    @TargetApi(SdkUtil.BASE)
    private void addBaseApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("fontScale").of(configuration.fontScale));
        apis.add(factory.withName("locale").of(configuration.locale.toString()));
        apis.add(factory.withName("orientation").of(new OrientationValue(configuration)));
        apis.add(factory.withName("screenLayout (long)").of(new ScreenLayoutLongValue(configuration)));
        apis.add(factory.withName("screenLayout (size)").of(new ScreenLayoutSizeValue(configuration)));
        apis.add(factory.withName("touchscreen").of(new TouchscreenValue(configuration.touchscreen)));
    }

    @TargetApi(SdkUtil.HONEYCOMB_MR2)
    private void addHoneycombMR2Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("screenHeightDp").of(configuration.screenHeightDp, "dp"));
        apis.add(factory.withName("screenWidthDp").of(configuration.screenWidthDp, "dp"));
        apis.add(factory.withName("smallestScreenWidthDp").of(configuration.smallestScreenWidthDp, "dp"));
    }

    @TargetApi(SdkUtil.MARSHMALLOW)
    private void addMarshmallowApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("isScreenRound()").of(configuration.isScreenRound()));
    }

}
