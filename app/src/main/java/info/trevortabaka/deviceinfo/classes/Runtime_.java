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
import info.trevortabaka.deviceinfo.value.MemoryValue;
import info.trevortabaka.deviceinfo.util.SdkUtil;

public class Runtime_ implements Class_ {
    private final java.lang.Runtime runtime;
    private final Collection<Api> apis = new ArrayList<>();

    @Inject
    public Runtime_(java.lang.Runtime runtime) {
        this.runtime = runtime;
        ApiFactory.ApiClassFactory factory = ApiFactory.newInstance(runtime.getClass());
        if (SdkUtil.IS_1_BASE) addBaseApis(factory.withApi(SdkUtil.BASE));
    }

    @TargetApi(SdkUtil.BASE)
    private void addBaseApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("availableProcessors()").of(runtime.availableProcessors()));
        apis.add(factory.withName("freeMemory()").of(new MemoryValue(runtime.freeMemory())));
        apis.add(factory.withName("maxMemory()").of(new MemoryValue(runtime.maxMemory())));
        apis.add(factory.withName("totalMemory()").of(new MemoryValue(runtime.totalMemory())));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
