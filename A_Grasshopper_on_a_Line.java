import java.io.*;
import java.util.*;

public class A_Grasshopper_on_a_Line{
    public static void main(String[] args) throws Exception{
        Grasshopper g=new Grasshopper();
        try{g.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class Grasshopper{
    public void run()throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int i=0;i<t;i++){
            String[] parts=br.readLine().split(" ");
            int[] a=new int[2];
            for(int j=0;j<parts.length;j++)a[j]=Integer.parseInt(parts[j]);
            arrHolder[i]=a;
        }
        for(int i=0;i<t;i++)solve(arrHolder[i]);
    }
    public void solve(int[] a){
        int x=a[0];int k=a[1];
        if(x%k==0)System.out.println(2+"\n"+(x-(k+1)/2)+" "+((k+1)/2));
        else System.out.println(1+"\n"+x);
    }
}