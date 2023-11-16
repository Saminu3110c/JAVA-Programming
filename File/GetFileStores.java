import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.FileSystem;
import java.io.IOException;

public class GetFileStores {
    public static void main(String[] args) {
        FileSystem fileSystem = FileSystems.getDefault();
        Iterable<FileStore> stores = fileSystem.getFileStores();

        long gigabyte = 1_073_741_824L;
        for(FileStore store:stores){
        try {
        System.out.format("\nStore: %-20s %-5s Capacity: %5dgb Unallocated: %6dgb", store.name(), store.type(), store.getTotalSpace()/gigabyte, store.getUnallocatedSpace()/gigabyte);
        } catch(IOException e) {
        e.printStackTrace();
        }
        }
    }
}