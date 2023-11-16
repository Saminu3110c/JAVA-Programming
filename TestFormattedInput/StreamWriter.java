import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class StreamWriter{
    public static void main(String[] args){
        StringWriter strWriter = new StringWriter();
        StreamWriter writer = new StreamWriter(strWriter);

        double myNumber = 38.35;
        writer.println(myNumber);
    }
}