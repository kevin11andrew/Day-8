package storage;

public class StorageFactory {
    public static Storage getStorage(int code)
    {
        switch (code) {
            // what is StorageImpl???
            case 2: return new StorageListImpl();
            case 3: return new StorageSortedImpl();
            default: return new StorageMapImpl();
        }
    }
}
