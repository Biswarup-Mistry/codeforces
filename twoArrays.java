
import java.util.Scanner;


class array{
    void run(){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(); //no of test cases
        int i=0;
        if ((t>=1) && (t<=Math.pow(10, 4))){
            int n;
            n=sc.nextInt();
            if(n>=1 && n<=Math.pow(10, 5)){
                int[] a1=new int[n];
                int[] a2=new int[n];
                for(i=0;i<n;i++){
                    a1[i]=sc.nextInt();
                }
                for(i=0;i<n;i++){
                    a2[i]=sc.nextInt();
                }
                for(i=0;i<n;i++){
                    System.out.println("a1["+i+"]="+a1[i]);
                }
                for(i=0;i<n;i++){
                    System.out.println("a2["+i+"]="+a2[i]);
                }
            }
        }        
    }
}


public class twoArrays{
    public static void main(String args[]){
        array a=new array();
        try{a.run();}
        catch(Exception e){System.out.println("The Exception is :=>"+e);}
    }
}