package info.trevortabaka.deviceinfo.ui;

import java.util.Comparator;

import info.trevortabaka.deviceinfo.api.Api;

public class SortingStrategies {
    public static final Comparator<? super Api> API_LEVEL = new Comparator<Api>() {
        @Override
        public int compare(Api first, Api second) {
            int x = first.getApiLevel();
            int y = second.getApiLevel();
            return (x < y) ? -1 : ((x == y) ? 0 : 1);
        }
    };

    public static final Comparator<? super Api> API_NAME = new Comparator<Api>() {
        @Override
        public int compare(Api first, Api second) {
            return first.getName().compareToIgnoreCase(second.getName());
        }
    };

    public static final Comparator<? super Api> CLASS_NAME = new Comparator<Api>() {
        @Override
        public int compare(Api first, Api second) {
            return first.getClassName().compareToIgnoreCase(second.getClassName());
        }
    };
}
