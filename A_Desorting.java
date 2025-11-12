import java.io.*;
import java.util.*;

public class A_Desorting{
    public static void main(String[] args) throws IOException{
        Desorting d=new Desorting();
        try{d.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class Desorting{
    public void run()throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            String[] parts=br.readLine().split(" ");
            int[] a=new int[n];
            for(int j=0;j<parts.length;j++)a[j]=Integer.parseInt(parts[j]);
            arrHolder[i]=a;
        }
        for(int i=0;i<t;i++)solve(arrHolder[i]);
    }
    public void solve(int[] a){
        List<Integer> list=new ArrayList<>();
        for(int x:a)list.add(x);
        int no_need=0;
        for(int i=0;i<list.size()-1;i++)if(list.get(i)>list.get(i+1))no_need=1;
        if(no_need==1)System.out.println("0");
        else{
            int min=Math.abs(list.get(0)-list.get(1));
            int x=0;int y=0;
            for(int i=0;i<list.size()-1;i++){
                if(min>Math.abs(list.get(i+1)-list.get(i)))min=list.get(i+1)-list.get(i);
            }
            System.out.println(min/2+1); 
        }
    }
}