import java.io.*;
import java.util.*;

public class Blackslex_and_Password{
    public static void main(String[] args) throws Exception{
        question q=new question();
        try{q.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class question{
    public void run()throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        long[][] arrHolder=new long[t][];
        for(int i=0;i<t;i++){
            //int n=Integer.parseInt(br.readLine());
            long[] a=new long[2];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){a[j]=Long.parseLong(parts[j]);}
            arrHolder[i]=a;
        }
        for(int i=0;i<t;i++)solve(arrHolder[i]);
    }
    public void solve(long[] a){
        long k=a[0];long x=a[1];
        System.out.println(k*x+1);
    }
}