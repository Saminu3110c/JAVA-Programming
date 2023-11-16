import java.util.Scanner;
public class NationalFlag{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the height of the flag: ");
        int height = scan.nextInt();
        System.out.print("Enter the width of the flag: ");
        int width = scan.nextInt();

        if((height | width) <= 0){
            System.out.println("Provide appropriate positive value for either the height or width");
        }

        System.out.println();
        System.out.println("The Nigerian National Flag");

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                System.out.print("*");
            }
             for(int j = 0; j < width; j++){
                System.out.print("\'");
            }
            for(int j = 0; j < width; j++){
                System.out.print("*");
            }
            System.out.println();
           
        }

    }

}