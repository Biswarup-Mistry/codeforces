import java.io.*;
import java.util.*;

public class A_Coins{
    public static void main(String[] args) throws Exception{
        Permutation p=new Permutation();
        try{p.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class Permutation{
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
        long n=a[0];long k=a[1];
        if(n%2==1 && k%2==0)System.out.println("NO");
        else System.out.println("YES");
    }
}