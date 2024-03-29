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
import android.os.Build;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;
import info.trevortabaka.deviceinfo.api.Class_;
import info.trevortabaka.deviceinfo.util.SdkUtil;
import info.trevortabaka.deviceinfo.value.SdkIntValue;

public class VERSION implements Class_ {
    private final Collection<Api> apis = new ArrayList<>();

    @Inject
    public VERSION() {
        ApiFactory.ApiClassFactory factory = ApiFactory.newInstance(Build.VERSION.class);
        if (SdkUtil.IS_1_BASE) addBaseApis(factory.withApi(SdkUtil.BASE));
        if (SdkUtil.IS_4_DONUT) addDonutApis(factory.withApi(SdkUtil.DONUT));
        if (SdkUtil.IS_23_MARSHMALLOW) add23Apis(factory.withApi(SdkUtil.MARSHMALLOW));
    }

    private void addBaseApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("VERSION.INCREMENTAL").of(android.os.Build.VERSION.INCREMENTAL));
        apis.add(factory.withName("VERSION.RELEASE").of(android.os.Build.VERSION.RELEASE));
        apis.add(factory.withName("VERSION.SDK").of(android.os.Build.VERSION.SDK));
    }

    private void addDonutApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("VERSION.CODENAME").of(android.os.Build.VERSION.CODENAME));
        apis.add(factory.withName("VERSION.SDK_INT").of(new SdkIntValue(android.os.Build.VERSION.SDK_INT)));
    }

    @TargetApi(SdkUtil.MARSHMALLOW)
    private void add23Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("VERSION.BASE_OS").of(android.os.Build.VERSION.BASE_OS));
        apis.add(factory.withName("VERSION.PREVIEW_SDK_INT").of(android.os.Build.VERSION.PREVIEW_SDK_INT));
        apis.add(factory.withName("VERSION.SECURITY_PATCH").of(android.os.Build.VERSION.SECURITY_PATCH));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
