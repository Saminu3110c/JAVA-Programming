import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;
import static java.lang.Math.min;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.nio.channels.*;
import java.nio.*;
import java.util.*;
import java.io.IOException;

public class PrimesToFile{
 public static void main(String[] args) {
 int primesRequired = 100; // Default count
 if (args.length > 0) {
 try {
 primesRequired = Integer.valueOf(args[0]).intValue();
 } catch (NumberFormatException e) {
 System.out.println("Prime count value invalid. Using default of "
 + primesRequired);
 }
 }
 long[] primes = new long[primesRequired]; // Array to store primes
 getPrimes(primes); // Calculate the primes
 Path file = createFilePath("Beginning Java Stuff", "primes.bin");
 writePrimesFile(primes, file); // Write the file
 }
 // Calculate enough primes to fill the array
 private static long[] getPrimes(long[] primes) {
 primes[0] = 2L; // Seed the first prime
 primes[1] = 3L; // and the second
 // Count of primes found – up to now, which is also the array index
 int count = 2;
 // Next integer to be tested
 long number = 5L;
 outer:
 for (; count < primes.length ; number += 2) {
 // The maximum divisor we need to try is square root of number
 long limit = (long)ceil(sqrt((double)number));
 // Divide by all the primes we have up to limit
 for (int i = 1; i < count && primes[i] <= limit; ++i)
 if (number % primes[i] == 0L) // Is it an exact divisor?
 continue outer; // yes, try the next number
 primes[count++] = number; // We got one!
 }
 return primes;
 }
 // Create the path for the named file in the specified directory
 // in the user home directory
 private static Path createFilePath(String directory, String fileName) {
 Path file = Paths.get(System.getProperty("user.home")).
 resolve(directory).resolve(fileName);
 try {
 // Make sure we have the directory
 Files.createDirectories(file.getParent());
 } catch (IOException e) {
 e.printStackTrace();
 System.exit(1);
 }
 System.out.println("New file is: " + file);
 return file;
 }
 // Write the array contents to file
 private static void writePrimesFile(long[] primes, Path file) {
 final int BUFFERSIZE = 100; // Byte buffer size
 try (WritableByteChannel channel = Files.newByteChannel(
 file, EnumSet.of(WRITE, CREATE))) {
 ByteBuffer buf = ByteBuffer.allocate(BUFFERSIZE);
 LongBuffer longBuf = buf.asLongBuffer(); // View buffer for type long
 int primesWritten = 0; // Count of primes written to fi le
 while (primesWritten < primes.length) {
 longBuf.put(primes, // Array to be written
 primesWritten, // Index of 1st element to write
 min(longBuf.capacity(), primes.length - primesWritten));
 buf.limit(8*longBuf.position()); // Update byte buffer position
 channel.write(buf);
 primesWritten += longBuf.position();
 longBuf.clear();
 buf.clear();
 }
 System.out.println("File written is " +
 ((FileChannel)channel).size() + " bytes.");
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}