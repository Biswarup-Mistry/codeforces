import java.io.*;
import java.util.*;

public class a14{
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
            int[] arr=new int[n-1];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){arr[j]=Integer.parseInt(parts[j]);}
            arrHolder[i]=arr;
        }
        /*for(int i=0;i<t;i++){
            for(int j=0;j<arrHolder[i].length;j++){System.out.print(arrHolder[i][j]+" ");}
            System.out.println();
        }*/
        for(int i=0;i<t;i++){
            check(arrHolder[i]);
        }
    }
    public void check(int[] arr){
        int sum=0;
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            sum=sum+(n*arr[i]);
        }
        System.out.println((-1*sum)/n);
    }
}