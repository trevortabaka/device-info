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
import info.trevortabaka.deviceinfo.value.StringArrayValue;
import info.trevortabaka.deviceinfo.value.TimeValue;

public class Build implements Class_ {
    private final Collection<Api> apis = new ArrayList<>();

    @Inject
    public Build() {
        ApiFactory.ApiClassFactory factory = ApiFactory.newInstance(android.os.Build.class);
        if (SdkUtil.IS_1_BASE) addBaseApis(factory.withApi(SdkUtil.BASE));
        if (SdkUtil.IS_3_CUPCAKE) addCupcakeApis(factory.withApi(SdkUtil.CUPCAKE));
        if (SdkUtil.IS_4_DONUT) addDonutApis(factory.withApi(SdkUtil.DONUT));
        if (SdkUtil.IS_8_FROYO) addFroyoApis(factory.withApi(SdkUtil.FROYO));
        if (SdkUtil.IS_9_GINGERBREAD) add9Apis(factory.withApi(SdkUtil.GINGERBREAD));
        if (SdkUtil.IS_14_ICE_CREAM_SANDWICH) add14Apis(factory.withApi(SdkUtil.ICE_CREAM_SANDWICH));
        if (SdkUtil.IS_21_LOLLIPOP) add21Apis(factory.withApi(SdkUtil.LOLLIPOP));
    }

    private void addBaseApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("BOARD").of(android.os.Build.BOARD));
        apis.add(factory.withName("BRAND").of(android.os.Build.BRAND));
        apis.add(factory.withName("DEVICE").of(android.os.Build.DEVICE));
        apis.add(factory.withName("FINGERPRINT").of(android.os.Build.FINGERPRINT));
        apis.add(factory.withName("HOST").of(android.os.Build.HOST));
        apis.add(factory.withName("ID").of(android.os.Build.ID));
        apis.add(factory.withName("MODEL").of(android.os.Build.MODEL));
        apis.add(factory.withName("PRODUCT").of(android.os.Build.PRODUCT));
        apis.add(factory.withName("TAGS").of(android.os.Build.TAGS));
        apis.add(factory.withName("TIME").of(new TimeValue(android.os.Build.TIME)));
        apis.add(factory.withName("TYPE").of(android.os.Build.TYPE));
        apis.add(factory.withName("USER").of(android.os.Build.USER));
    }

    private void addCupcakeApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("DISPLAY").of(android.os.Build.DISPLAY));
    }

    private void addDonutApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("CPU_ABI").of(android.os.Build.CPU_ABI));
        apis.add(factory.withName("MANUFACTURER").of(android.os.Build.MANUFACTURER));
    }

    @TargetApi(android.os.Build.VERSION_CODES.FROYO)
    private void addFroyoApis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("BOOTLOADER").of(android.os.Build.BOOTLOADER));
        apis.add(factory.withName("CPU_ABI2").of(android.os.Build.CPU_ABI2));
        apis.add(factory.withName("HARDWARE").of(android.os.Build.HARDWARE));
        apis.add(factory.withName("RADIO").of(android.os.Build.RADIO));
    }

    @TargetApi(android.os.Build.VERSION_CODES.GINGERBREAD)
    private void add9Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("SERIAL").of(android.os.Build.SERIAL));
    }

    @TargetApi(SdkUtil.ICE_CREAM_SANDWICH)
    private void add14Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("getRadioVersion()").of(android.os.Build.getRadioVersion()));
    }

    @TargetApi(SdkUtil.LOLLIPOP)
    private void add21Apis(ApiFactory.ApiLevelFactory factory) {
        apis.add(factory.withName("SUPPORTED_32_BIT_ABIS").of(new StringArrayValue(android.os.Build.SUPPORTED_32_BIT_ABIS)));
        apis.add(factory.withName("SUPPORTED_64_BIT_ABIS").of(new StringArrayValue(android.os.Build.SUPPORTED_64_BIT_ABIS)));
        apis.add(factory.withName("SUPPORTED_ABIS").of(new StringArrayValue(android.os.Build.SUPPORTED_ABIS)));
    }

    @Override
    public Collection<Api> apis() {
        return apis;
    }
}
