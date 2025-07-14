
import java.util.Scanner;


class array{
    void run(){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(); //no of test cases
        int i=0;
        int[][] arrayHolder=new int[2*t][]; //arrayHolder
        if ((t>=1) && (t<=Math.pow(10, 4))){
            for (i=0;i<t;i++){
                int n;
                n=sc.nextInt();
                if(n>=1 && n<=Math.pow(10, 5)){
                    int[] a1=new int[n]; //array 1
                    int[] a2=new int[n]; //array 2
                    for(int j=0;j<n;j++){
                        a1[j]=sc.nextInt(); //getting the a1's elements
                    }
                    for(int j=0;j<n;j++){
                        a2[j]=sc.nextInt(); //getting the a2's elements
                    }
                    for(int j=0;j<n;j++){
                        System.out.println("a1["+j+"]="+a1[j]);  //showing the a1's elements
                    }
                    for(int j=0;j<n;j++){
                        System.out.println("a2["+j+"]="+a2[j]);  //showing the a1's elements
                    }
                    arrayHolder[2*i]=a1; //array head adding of a1
                    arrayHolder[2*i+1]=a2; //array head adding of a2
                    for(int a=0;a<2*t;a++){
                        for (int b=0;b<n;b++){
                            System.out.println("arrayHolder["+a+"]["+b+"]="+arrayHolder[a][b]); //printing arrayHolder
                        }
                    }
                }
                //sc.close();
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