import java.io.StreamTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Exercise1{

// throws InvalidUserInputException 
 public String readString(){
 if (readToken() == StreamTokenizer.TT_WORD || ttype == '\"'
 || ttype == '\"') {
 return tokenizer.sval;
 } //else {
//  throw new InvalidUserInputException("readString() failed."
//  + "Input data is not a string");
//  }
 }


 // Helper method to read the next token
 public int readToken() {
 try {
 ttype = tokenizer.nextToken();
 return ttype;
 } catch (IOException e) { // Error reading in nextToken()
 e.printStackTrace();
 System.exit(1); // End the program
 }
 return 0;
 }
 // Object to tokenize input from the standard input stream
 private StreamTokenizer tokenizer = new StreamTokenizer(
 new BufferedReader(
 new InputStreamReader(System.in)));
 private int ttype; // Stores the token type code

}
