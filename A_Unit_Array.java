import java.io.*;
import java.util.*;

public class A_Unit_Array{
    public static void main(String[] args) throws Exception{
        Unit u=new Unit();
        try{u.run();}catch(Exception e){System.out.println("The Exception is + : "+e);}
    }
}

class Unit{
    public void run()throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder= new int[t][];
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            String[] parts=br.readLine().split(" ");
            int[] a=new int[n];
            for(int j=0;j<parts.length;j++){a[j]=Integer.parseInt(parts[j]);}
            arrHolder[i]=a;
        }
        for(int i=0;i<t;i++)solve(arrHolder[i]);
    }
    public void solve(int[] a){
        int pos=0;int neg=0;int n=a.length;int count=0;
        for(int x:a){if(x>0){pos++;}else{ neg++;}}
        Arrays.sort(a);
        while(neg>pos || neg%2==1){
            neg--;pos++;count++;
        }
        System.out.println(count);
    }
}