package info.trevortabaka.deviceinfo.api;

class MemoryApi extends AbstractApi {
    private final long memory;

    MemoryApi(int apiLevel, String name, long memory) {
        super(apiLevel, name);
        this.memory = memory;
    }

    @Override
    public String getValue() {
        long kibibytes = memory / 1024;
        long mibibytes = kibibytes / 1024;
        return memory + " bytes (" + kibibytes + " KiB / " + mibibytes + " MiB)";
    }
}
