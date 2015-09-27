package info.trevortabaka.deviceinfo.util;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionsUtil {

    public static <T> Collection<T> combine(@NonNull T... things) {
        Collection<T> collection = new ArrayList<>(things.length);
        Collections.addAll(collection, things);
        return collection;
    }

    public static <T> Collection<T> combine(@NonNull Collection<T>... things) {
        Collection<T> collection = new ArrayList<>(things.length);
        for (Collection<T> thing : things) {
            collection.addAll(thing);
        }
        return collection;
    }
}
