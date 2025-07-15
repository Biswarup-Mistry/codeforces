
import java.util.Scanner;

//twoArrays1

class arrays{
    void run(){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(); //testcases
        if (t>=1 && t<=Math.pow(10, 4)){
            int n=sc.nextInt();
            for (int i=0;i<2*t;i+=2){
                
            }
        }
        sc.close();
    }
}



public class twoArrays1{
    public static void main(String[] args) {
        arrays a=new arrays();
        try {
            a.run();
        } catch (Exception e) {
            System.out.println("The Error is :-> "+e);
        }
    }
}