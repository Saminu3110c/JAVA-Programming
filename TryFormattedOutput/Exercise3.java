public class Exercise3{
    public static void main(String[] args){
        int count = 0;
        for(int sn=1; sn<21; ++sn){
            double num = (-50.0)*Math.random();
            System.out.printf("     %1$5d)  %2$5.2f", sn, num);
            if(++count%5==0){
                System.out.printf("\n");
            }

        }
    }







     //Formatting Characters and Strings
        // int count = 0;
        // for(int ch = 'a'; ch<= 'z'; ++ch){
        //     System.out.printf("     %1$4c%1$4x", ch);
        //     if(++count%6 == 0){
        //         System.out.printf("%n");
        //     }
        // }

        //  for(int i = 0 ; i < values.length ; ++i) {
        //     values[i] = (int)(100.0*Math.random());
        // }
}