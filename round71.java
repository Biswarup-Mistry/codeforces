import java.io.*;
import java.util.*;

public class round71{
    public static void main(String[] args) throws Exception{
        question q=new question();
        try{q.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class question{
    public void run()throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int i=0;i<t;i++){
            //int n=Integer.parseInt(br.readLine());
            int k=Integer.parseInt(br.readLine());
            int[] a=new int[k];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){a[j]=Integer.parseInt(parts[j]);}
            arrHolder[i]=a;
        }
        for(int i=0;i<t;i++)solve(arrHolder[i]);
    }
    public void solve(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            sum += Math.abs(a[i] - a[i+1]);
        }

        int newtime = sum;

        // remove first element
        newtime = Math.min(newtime, sum - Math.abs(a[0] - a[1]));

        // remove last element
        newtime = Math.min(newtime, sum - Math.abs(a[a.length-2] - a[a.length-1]));

        // remove middle element
        for (int i = 1; i < a.length - 1; i++) {
            int old1 = Math.abs(a[i-1] - a[i]) + Math.abs(a[i] - a[i+1]);
            int new1 = Math.abs(a[i-1] - a[i+1]);
            int candidate = sum - old1 + new1;
            newtime = Math.min(newtime, candidate);
        }

        System.out.println(newtime);

    }
}