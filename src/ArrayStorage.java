import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;

    void clear() {
        Arrays.fill(storage, null);
        storageSize = 0;
    }

    void save(Resume r) {
        if (storageSize == storage.length) System.out.println("Storage full");
        else if (get(r.uuid) == null) {
            storage[storageSize] = r;
            storageSize++;
        } else System.out.println(r.uuid + " is already in the storage");
    }

    Resume get(String uuid) {
        if (storageSize == 0) return null;
        for (int i = 0; i < storageSize; i++) {
            //search first
            if (storage[i].uuid.equals(uuid)) return storage[i];
            //search end
            if (storage[storageSize - 1 - i].uuid.equals(uuid)) return storage[storageSize - 1 - i];
        }
        return null;
    }

    void delete(String uuid) {
        if (storageSize == 0) return;
        //delete element. search first
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                storage[i] = storage[storageSize - 1];
                storageSize--;
                break;
            }
            //delete element.search end
            if (storage[storageSize - 1 - i].uuid.equals(uuid)) {
                storage[storageSize - 1 - i] = null;
                storage[storageSize - 1 - i] = storage[storageSize - 1];
                storageSize--;
                break;
            }
        }
    }

    Resume[] getAll() {
        Resume[] arrWithoutNull = new Resume[storageSize];
        System.arraycopy(storage, 0, arrWithoutNull, 0, storageSize);
        return arrWithoutNull;
    }

    int size() {
        return storageSize;
    }
}
