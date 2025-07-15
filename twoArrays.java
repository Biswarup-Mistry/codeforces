
import java.util.Scanner;


class array{
    void run(){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(); //no of test cases
        int[][] arrayHolder=new int[2*t][]; //arrayHolder
        if ((t>=1) && (t<=Math.pow(10, 4))){
            int n;
            for (int i=0;i<t;i++){
                n=sc.nextInt();
                //System.out.println("n="+n);
                if(n>=1 && n<=Math.pow(10, 5)){
                    int[] a1=new int[n]; //array 1
                    int[] a2=new int[n]; //array 2
                    for(int j=0;j<n;j++){
                        a1[j]=sc.nextInt(); //getting the a1's elements
                    }
                    for(int j=0;j<n;j++){
                        a2[j]=sc.nextInt(); //getting the a2's elements
                    }
                    /*for(int j=0;j<n;j++){
                        System.out.println("a1["+j+"]="+a1[j]);  //showing the a1's elements
                    }
                    for(int j=0;j<n;j++){
                        System.out.println("a2["+j+"]="+a2[j]);  //showing the a1's elements
                    }*/
                    arrayHolder[2*i]=a1; //array head adding of a1
                    arrayHolder[2*i+1]=a2; //array head adding of a2  
                }
            }
        }
        /*for (int i = 0; i < 2 * t; i++) { 
            if (arrayHolder[i] != null) {
                for (int j = 0; j < arrayHolder[i].length; j++) {
                    System.out.println("arrayHolder[" + i + "][" + j + "] = " + arrayHolder[i][j]);
                }
            }

        }*/
        //write here the code
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
        int max1,max2;
        for (i = 0; i < 2 * t; i+=2) {
            if (arrayHolder[i] != null) {
                for (int j = 0; j < arrayHolder[i].length; j++) {
                    if(arrayHolder[i][j]<arrayHolder[i][j+1]){
                        max1=arrayHolder[i][j+1];
                    }
                    else{
                        max1=arrayHolder[i][j];
                    }
                    System.out.println("arrayHolder[" + i + "][" + j + "] = " + arrayHolder[i][j]);
                }
            }

        }






        sc.close();        
    }
}


public class twoArrays{
    public static void main(String args[]){
        array a=new array();
        try{a.run();}
        catch(Exception e){System.out.println("The Exception is :=>"+e);}
    }
}