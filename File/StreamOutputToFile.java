import java.nio.file.*;
import java.nio.*;
import java.io.*;
public class StreamOutputToFile {
 public static void main(String[] args) {
 final int count = 50; // Number of values
 long[] fiboNumbers = {0L,0L}; // Array of 2 elements
 int index = 0; // Index to fi bonumbers
 ByteBuffer buf = ByteBuffer.allocate(count*8); // Buffer for output
 LongBuffer longBuf = buf.asLongBuffer(); // View buffer for type long
 Path file = Paths.get(System.getProperty("user.home")).
 resolve("Beginning Java Stuff").resolve("fibonnaci.bin");
 try {
 // Create parent directory if it doesn’t exist
 Files.createDirectories(file.getParent());
 } catch(IOException e) {
 System.err.println("Error creating directory: " + file.getParent());
 e.printStackTrace();
 System.exit(1);
 }
 System.out.println("New file is: " + file);
 try(BufferedOutputStream fileOut =
 new BufferedOutputStream(Files.newOutputStream(file))){
 // Generate Fibonacci numbers in buffer
 for(int i = 0 ; i < count ; ++i) {
 if(i < 2)
 fiboNumbers[index] = i;
 else
 fiboNumbers[index] = fiboNumbers[0] + fiboNumbers[1];
 longBuf.put(fiboNumbers[index]);
 index = ++index%2;
 }
 // Write the numbers to the fi le
 fileOut.write(buf.array(), 0, buf.capacity());
 System.out.println("File written.");
 } catch(IOException e) {
    System.err.println("Error writing file: " + file);
 e.printStackTrace();
 }
 }
}