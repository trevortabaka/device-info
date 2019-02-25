package info.trevortabaka.deviceinfo.ui;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import info.trevortabaka.deviceinfo.api.Api;
import info.trevortabaka.deviceinfo.api.ApiFactory;

import static org.junit.Assert.assertEquals;

public class SortingStrategiesTest {

    @Test
    public void sortByApiLevel() {
        List<Api> apis = new ArrayList<>();

        ApiFactory.ApiClassFactory apiClassFactory = ApiFactory.newInstance(getClass());
        apis.add(apiClassFactory.withApi(2).withName("apiA").of("valueA"));
        apis.add(apiClassFactory.withApi(1).withName("apiB").of("valueB"));
        apis.add(apiClassFactory.withApi(3).withName("apiA").of("valueA"));
        apis.add(apiClassFactory.withApi(1).withName("apiA").of("valueA"));

        apis.sort(SortingStrategies.API_LEVEL);

        assertEquals(1, apis.get(0).getApiLevel());
        assertEquals(1, apis.get(1).getApiLevel());
        assertEquals(2, apis.get(2).getApiLevel());
        assertEquals(3, apis.get(3).getApiLevel());
    }

    @Test
    public void sortByApiName() {
        List<Api> apis = new ArrayList<>();

        ApiFactory.ApiClassFactory apiClassFactory = ApiFactory.newInstance(getClass());
        apis.add(apiClassFactory.withApi(2).withName("apiB").of("valueB"));
        apis.add(apiClassFactory.withApi(1).withName("apiB").of("valueB"));
        apis.add(apiClassFactory.withApi(2).withName("apiA").of("valueA"));
        apis.add(apiClassFactory.withApi(1).withName("apiA").of("valueA"));

        apis.sort(SortingStrategies.API_NAME);

        assertEquals("apiA", apis.get(0).getName());
        assertEquals("apiA", apis.get(1).getName());
        assertEquals("apiB", apis.get(2).getName());
        assertEquals("apiB", apis.get(3).getName());
    }

    @Test
    public void sortByClassName() {
        List<Api> apis = new ArrayList<>();

        apis.add(ApiFactory.newInstance(C.class).withApi(1).withName("apiA").of("valueA"));
        apis.add(ApiFactory.newInstance(B.class).withApi(1).withName("apiA").of("valueA"));
        apis.add(ApiFactory.newInstance(A.class).withApi(1).withName("apiA").of("valueA"));

        apis.sort(SortingStrategies.CLASS_NAME);

        assertEquals("A", apis.get(0).getClassName());
        assertEquals("B", apis.get(1).getClassName());
        assertEquals("C", apis.get(2).getClassName());
    }

    private static class A { }
    private static class B { }
    private static class C { }
}