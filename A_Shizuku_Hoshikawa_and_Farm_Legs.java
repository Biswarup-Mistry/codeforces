import java.io.*;
import java.util.*;

public class A_Shizuku_Hoshikawa_and_Farm_Legs{
    public static void main(String[] args) throws Exception{
        Legs l=new Legs();
        try{l.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class Legs{
    public void run()throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int i=0;i<t;i++){
            String[] parts=br.readLine().split(" ");
            int[] a=new int[parts.length];
            for(int j=0;j<parts.length;j++){
                a[j]=Integer.parseInt(parts[j]);
            }
            arrHolder[i]=a;
        }
        for(int i=0;i<t;i++){counting(arrHolder[i]);}
    }
    public void counting(int[] a){
        int n=a[a.length-1];
        if(n%2==0)System.out.println(Math.floorDiv(n, 4)+1);
        else System.out.println(0);
    }
}