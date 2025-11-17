import java.io.*;
import java.util.*;

public class A_Twin_Permutations{
    public static void main(String[] args) throws Exception{
        Permutation p=new Permutation();
        try{p.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class Permutation{
    public void run()throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] a=new int[n];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++)a[j]=Integer.parseInt(parts[j]);
            arrHolder[i]=a;
        }
        for(int i=0;i<t;i++)solve(arrHolder[i]);
    }
    public void solve(int[] a){
        List<Integer> list=new ArrayList<>();
        int n=a.length;
        for(int x:a)list.add(n+1-x);
        for(int x:list)System.out.print(x+" ");
        System.out.println();
    }
}