
import java.util.Scanner;


class Array {
    void run(){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(); //no of test cases
        int[][] arrayHolder=new int[2*t][]; //arrayHolder
        if ((t>=1) && (t<=Math.pow(10, 4))){
            int n;
            for (int i=0;i<t;i++){
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
                    arrayHolder[2*i]=a1; //array head adding of a1
                    arrayHolder[2*i+1]=a2; //array head adding of a2  
                }
            }
        }

        //writen here the swaping code
        int i=0;
        while (i<2*t){
            if (arrayHolder[i]!=null && arrayHolder[i+1]!=null){
                for (int j=0;j<arrayHolder[i].length;j++){
                    if (arrayHolder[i][j]<arrayHolder[i+1][j]){
                        int a=arrayHolder[i][j];
                        arrayHolder[i][j]=arrayHolder[i+1][j];
                        arrayHolder[i+1][j]=a;
                    }
                }
            }
            i+=2;
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (i = 0; i < 2 * t; i += 2) {  // step by 2 for each test case pair
                if (arrayHolder[i] != null && arrayHolder[i + 1] != null) {
                    int[] a1 = arrayHolder[i];
                    int[] a2 = arrayHolder[i + 1];

                    //int max1 = Integer.MIN_VALUE;
                    //int max2 = Integer.MIN_VALUE;

                    // Find max in both arrays
                    for (int j = 0; j < a1.length; j++) {
                        if (a1[j] > max1) max1 = a1[j];
                        if (a2[j] > max2) max2 = a2[j];
                    }

                    // Print the sum of max1 and max2
                    System.out.println("Sum of max1 and max2: " + (max1 + max2));

                    // Print the contents of a1
                    System.out.print("Array a1: ");
                    for (int j = 0; j < a1.length; j++) {
                        System.out.print(a1[j] + " ");
                    }
                    System.out.println(); // newline after array
                }
            
        }
        sc.close();        
    }
}


public class main {
    public static void main(String args[]){
        Array a=new Array();
        try{a.run();}
        catch(Exception e){System.out.println("The Exception is :=>"+e);}
    }
}