package info.trevortabaka.deviceinfo.util;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MyCollections {

    public static <T> Collection<T> list(@NonNull T... things) {
        Collection<T> collection = new ArrayList<>(things.length);
        Collections.addAll(collection, things);
        return collection;
    }

    public static <T> Collection<T> list2(@NonNull Collection<T>... things) {
        Collection<T> collection = new ArrayList<>(things.length);
        for (Collection<T> thing : things) {
            collection.addAll(thing);
        }
        return collection;
    }
}
