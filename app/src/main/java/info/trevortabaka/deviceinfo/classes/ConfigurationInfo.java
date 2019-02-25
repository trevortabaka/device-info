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

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.util.SdkUtil;
import info.trevortabaka.deviceinfo.value.InputFeaturesValue;
import info.trevortabaka.deviceinfo.value.KeyboardValue;
import info.trevortabaka.deviceinfo.value.NavigationValue;
import info.trevortabaka.deviceinfo.value.TouchscreenValue;

public class ConfigurationInfo implements Class_ {
    private final android.content.pm.ConfigurationInfo configurationInfo;
    private final Collection<Api> apis = new ArrayList<>();

    @Inject
    public ConfigurationInfo(android.content.pm.ConfigurationInfo configurationInfo) {
        this.configurationInfo = configurationInfo;
        ApiFactory.ApiClassFactory factory = ApiFactory.newInstance(configurationInfo.getClass());
        if (SdkUtil.IS_3_CUPCAKE) add3Apis(factory.withApi(SdkUtil.CUPCAKE));
        if (SdkUtil.IS_4_DONUT) add4Apis(factory.withApi(SdkUtil.DONUT));
    }

    private void add4Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("reqGlEsVersion").of(configurationInfo.reqGlEsVersion));
        apis.add(factory.withName("getGlEsVersion()").of(configurationInfo.getGlEsVersion()));
    }

    private void add3Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("reqInputFeatures").of(new InputFeaturesValue(configurationInfo)));
        apis.add(factory.withName("reqKeyboardType").of(new KeyboardValue(configurationInfo)));
        apis.add(factory.withName("reqNavigation").of(new NavigationValue(configurationInfo)));
        apis.add(factory.withName("reqTouchScreen").of(new TouchscreenValue(configurationInfo.reqTouchScreen)));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
