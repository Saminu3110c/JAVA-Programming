import java.util.Scanner;

public class Sorting{
    Scanner scan = new Scanner(System.in);
    public int Sort(){
        System.out.print("Enter the number of elements to be sorted: ");
        int arraySize = scan.nextInt();
        int[] myArray = new int[arraySize];

        System.out.print("\n\nEnter the numbers to be sorted: ");
        for(int i = 0; i < arraySize; i++){
            myArray[i] = scan.nextInt();
        }

        

    }
}