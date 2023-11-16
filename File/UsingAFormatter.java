import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*; // Files and Path
import java.nio.channels.WritableByteChannel;
import java.nio.*; // ByteBuffer and CharBuffer
import java.util.*; // Formatter and EnumSet
import java.io.IOException;

public class UsingAFormatter {
 public static void main(String[] args) {
 String[] phrases = {"Rome wasn't burned in a day.",
 "It's a bold mouse that sits in the cat's ear.",
 "An ounce of practice is worth a pound of instruction."
 };
 String separator = System.lineSeparator(); // Get line separator
 Path file = Paths.get(System.getProperty("user.home")).
 resolve("Beginning Java Stuff").resolve("Phrases.txt");
 try {
 // Make sure we have the directory
 Files.createDirectories(file.getParent());
 } catch (IOException e) {
 e.printStackTrace();
 System.exit(1);
 }
 System.out.println("New file is: " + file);
 try (WritableByteChannel channel = Files.newByteChannel(
 file, EnumSet.of(WRITE, CREATE, APPEND))) {
 ByteBuffer buf = ByteBuffer.allocate(1024);
 CharBuffer charBuf = buf.asCharBuffer(); // Create a view buffer
 System.out.println("Char view buffer:");
 System.out.printf("position = %2d Limit = %4d capacity = %4d%n",
 charBuf.position(),charBuf.limit(),charBuf.capacity());
 Formatter formatter = new Formatter(charBuf);
 // Write to the view buffer using a formatter
 int number = 0; // Proverb number
 for(String phrase : phrases) {
 formatter.format("Proverb%2d: %s%s", ++number, phrase, separator);
 System.out.println("\nView buffer after loading:");
 System.out.printf("position = %2d Limit = %4d capacity = %4d%n",
 charBuf.position(), charBuf.limit(),charBuf.capacity());
 charBuf.flip(); // Flip the view buffer
 System.out.println("View buffer after flip:");
 System.out.printf("position = %2d Limit = %4d length = %4d%n",
 charBuf.position(),charBuf.limit(),charBuf.length());
 buf.limit(2*charBuf.length()); // Set byte buffer limit
 System.out.println("Byte buffer after limit update:");
 System.out.printf("position = %2d Limit = %4d length = %4d%n",
 buf.position(),buf.limit(), buf.remaining());
 channel.write(buf); // Write buffer to the channel
 System.out.println("Buffer contents written to file.");
 buf.clear();
 charBuf.clear();
 }
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}