package info.trevortabaka.deviceinfo.api;

public interface Api extends ApiValue {

    int getApiLevel();

    String getClassName();

    String getPackageName();

    String getName();
}
