import java.nio.file.*;
import java.nio.*;
import java.io.*;
public class StreamInputFromFile {
 public static void main(String[] args) {
 Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("fibonnaci.bin");
 if(!Files.exists(file)) {
 System.out.println(file + " does not exist. Terminating program.");
 System.exit(1);
 }
 final int count = 6; // Number of values to be read each time
 // Buffer to hold count values
 ByteBuffer buf = ByteBuffer.allocate(8*count);
 LongBuffer values = buf.asLongBuffer();
 byte[] bytes = buf.array(); // Backing array for buf
 int totalRead = 0; // Total value read
 try(BufferedInputStream fileIn =
 new BufferedInputStream(Files.newInputStream(file))){
 int numberRead = 0;
 while(true) {
 numberRead = fileIn.read(bytes, 0, bytes.length);
 if(numberRead == -1) // EOF reached
 break;
 totalRead += numberRead/8; // Increment total
 for(int i = 0 ; i < numberRead/8 ; ++i) // Access as many as there are
 System.out.format("%12d", values.get());
 System.out.println(); // New line
 values.flip(); // Reset for next input
 }
 System.out.format("%d values read.%n", totalRead);
 } catch(IOException e) {
 System.err.println("Error writing file: " + file);
 e.printStackTrace();
 }
 }
}