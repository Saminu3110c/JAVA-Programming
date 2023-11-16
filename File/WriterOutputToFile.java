import java.io.*;
import java.nio.file.*;
import java.nio.charset.Charset;
public class WriterOutputToFile {
 public static void main(String[] args) {
 String[] sayings = {"A nod is as good as a wink to a blind horse.",
 "Least said, soonest mended.",
 "There are 10 kinds of people in the world, " +
 "those that understand binary and those that don't.",
 "You can't make a silk purse out of a sow's ear.",
 "Hindsight is always twenty-twenty.",
 "Existentialism has no future.",
 "Those who are not confused are misinformed.",
 "Better untaught that ill-taught."};
 Path file = Paths.get(System.getProperty("user.home")).
 resolve("Beginning Java Stuff").resolve("Sayings.txt");
 try {
 // Create parent directory if it doesn’t exist
 Files.createDirectories(file.getParent());
 } catch(IOException e) {
 System.err.println("Error creating directory: " + file.getParent());
 e.printStackTrace();
 System.exit(1);
 }
 try(BufferedWriter fileOut = Files.newBufferedWriter(
 file, Charset.forName("UTF-16"))){
 // Write saying to the fi le
 for(int i = 0 ; i < sayings.length ; ++i) {
 fileOut.write(sayings[i], 0, sayings[i].length());
 fileOut.newLine(); // Write separator
 }
 System.out.println("File written.");
 } catch(IOException e) {
 System.err.println("Error writing file: " + file);
 e.printStackTrace();
 }
 }
}