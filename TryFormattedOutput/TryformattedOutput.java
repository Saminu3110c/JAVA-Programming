public class TryFormattedOutput{
    public static void main(String[] args){
        int a = 5, b = 15, c = 255;
        double x = 27.5, y = 33;
        // System.out.printf("x = %f y = %g", x, y);
        // System.out.printf(" a = %d b = %x c = %o", a, b, c);

        //using argument-index
        // System.out.printf("x = %2$f y = %1$g", x, y);
        // System.out.printf(" a = %3$d b = %1$x c = %2$o", a, b, c);

        //using < to repeat an argument-index
        // System.out.printf("%na = %3$d b = %<x c = %<o", a, b, c);

        //specifying the width and precision
        //  System.out.printf("x = %15f y = %8g", x, y);
        //  System.out.printf(" a = %1$5d b = %2$5x c = %3$2o", a, b, c);

        //System.out.printf("%na = %1$5d b = %2$5x c = %3$5o", a, b, c);
        //justifying output to the left using '-' flag
        //System.out.printf("%na = %1$-5d b = %2$-5x c = %3$-5o", a, b, c);

        //Adding precition or decimal place
        //  x = 27.5; y = 33.75;
        // System.out.printf("x = %15.4f y = %14.3f", x, y);

        //Formatting Characters and Strings
        // int count = 0;
        // for(int ch = 'a'; ch<= 'z'; ++ch){
        //     System.out.printf("     %1$4c%1$4x", ch);
        //     if(++count%6 == 0){
        //         System.out.printf("%n");
        //     }
        // }

        // To output the character % you use %%
        // int percentage = 75;
        // System.out.printf("\n%1$d%%", percentage);

        //using %s specifier to output a string
        // String str = "The quick brown fox.";
        // System.out.printf("%nThe string is:%n%s%n%1$25s", str);

        //Formatting data into a string
        x = 27.5; y = 33.75;
        // String outString = String.format("x = %15.2f y = %14.3f", x, y);
        // System.out.print(outString);

        //Using a java.util.Formatter object to format data
        StringBuffer buf = new StringBuffer();
        java.util.Formatter formatter = new java.util.Formatter(buf);
        formatter.format("x = %15.2f y = %14.3f", x, y);
        System.out.print(buf);
    }
}