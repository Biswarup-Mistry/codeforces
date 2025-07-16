import java.util.*;

public class Main {
    public static void main(String args[]){
        twoArrays t=new twoArrays();
        try {
            t.run();
        } catch (Exception e) {
            System.out.println("The error is :-> "+e);
        }
    }
}

class twoArrays{
    void run(){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[] max=new int[2*t];
        int[][] ah=new int[2*t][];
        int max1=0;
        int max2=0;
        if (t>=1 && t<=Math.pow(10, 4)){
            for (int i=0;i<t;i++){
                int n=sc.nextInt();
                int[] a1=new int[n];
                int[] a2=new int[n];
                if(n>=1 && n<=Math.pow(10, 5)){
                    //for(int i=0;i<t;i++){ //taking inputs
                    for(int j=0;j<n;j++){
                        a1[j]=sc.nextInt();
                    }
                    for(int j=0;j<n;j++){
                        a2[j]=sc.nextInt();
                    }
                    ah[2*i]=a1;
                    ah[2*i+1]=a2;
                    //}
                }
            }
            //swapping
            for(int i=0;i<2*t;i+=2){
                if(ah[i]!=null && ah[i+1]!=null){
                    for(int j=0;j<ah[i].length;j++){
                        if(ah[i][j]<ah[i+1][j]){
                            int b=ah[i][j];
                            ah[i][j]=ah[i+1][j];
                            ah[i+1][j]=b;
                        }
                    }
                }
            }
            //finding maximum
            for (int i=0;i<2*t;i+=2){
                if (ah[i]!=null && ah[i+1]!=null){
                    for (int j=0;j<ah[i].length;j++){
                        if(ah[i][j]>max1){max1=ah[i][j];}
                        if(ah[i+1][j]>max2){max2=ah[i+1][j];}
                    }
                }
                max[i]=max1;
                max[i+1]=max2;
                max1=0;
                max2=0;
            }
            //printing
            for (int i=0;i<2*t;i+=2){
                if(ah[i]!=null && ah[i+1]!=null){
                    System.out.println(max[i]+max[i+1]);
                    for (int j=0;j<ah[i].length;j++){
                        System.out.print(ah[i][j]+" ");
                    }
                    System.out.println();
                    for (int j=0;j<ah[i+1].length;j++){
                        System.out.print(ah[i+1][j]+" ");
                    }
                    System.out.println();
                }
            }
        }
        sc.close();
    }
}
