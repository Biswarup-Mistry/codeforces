import java.io.*;
import java.util.*;

public class B_Sequence_Game{
    public static void main(String[] args) throws IOException{
        Cost c=new Cost();
        try{c.run();}catch(Exception e){System.out.println("The exception is : "+e);}
    }
}

class Cost{
    public void run() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] arr=new int[n];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){arr[j]=Integer.parseInt(parts[j]);}
            arrHolder[i]=arr;
        }
        int[][] output=new int[t][];
        for(int i=0;i<t;i++){
            int[] a=new int[2*arrHolder[i].length];
            a[0]=arrHolder[i][0];
            int m=1;int n=1;
            while(m<arrHolder[i].length){
                if(arrHolder[i][m]>=arrHolder[i][m-1]){a[n]=arrHolder[i][m];m++;n++;}
                else{a[n]=arrHolder[i][m];a[n+1]=arrHolder[i][m];m++;n+=2;}
            }
            output[i]=a;
        }
        int[] count=new int[t];
        for(int i=0;i<t;i++){
            for(int j=0;j<output[i].length;j++){
                if(output[i][j]!=0){count[i]+=1;}
            }
        }
        for(int i=0;i<t;i++){
            System.out.println(count[i]);
            for(int j=0;j<output[i].length;j++){
                if(output[i][j]!=0){System.out.print(output[i][j]+" ");}
            }
            System.out.println();
        }
    }
}