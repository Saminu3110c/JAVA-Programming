import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.nio.channels.*;
import java.util.EnumSet;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BufferStateTrace {
 public static void main(String[] args) {
 String phrase = "Garbage in, garbage out.\n";
 Path file = Paths.get(System.getProperty("user.home")).
 resolve("Beginning Java Stuff").resolve("charData.txt");
 try {
 // Make sure we have the directory
 Files.createDirectories(file.getParent());
 } catch (IOException e) {
 e.printStackTrace();
 System.exit(1);
 }
 System.out.println("New file is: " + file);
 try (WritableByteChannel channel = Files.newByteChannel(file,
 EnumSet.of(WRITE, CREATE))) {
 ByteBuffer buf = ByteBuffer.allocate(1024);
 System.out.printf(
 "\nNew buffer: position = %1$2d Limit = %2$4d capacity = %3$4d",
 buf.position(), buf.limit(), buf.capacity());
 // Load the data into the buffer
 for(char ch : phrase.toCharArray())
 buf.putChar(ch);
 System.out.printf(
 "\nBuffer after loading: position = %1$2d Limit = %2$4d capacity = %3$4d",
 buf.position(), buf.limit(), buf.capacity());
 buf.flip(); // Flip the buffer ready for fi le write
 System.out.printf(
 "\nBuffer after flip: position = %1$2d Limit = %2$4d capacity = %3$4d",
 buf.position(), buf.limit(), buf.capacity());
 channel.write(buf); // Write the buffer to the fi le channel
 buf.flip();
 channel.write(buf); // Write the buffer again to the fi le channel
 System.out.println("\nBuffer contents written to the file - twice.");
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}
