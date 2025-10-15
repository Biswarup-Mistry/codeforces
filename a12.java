import java.util.*;
import java.io.*;

public class a12 {
    public static void main(String[] args) throws IOException{
        count c=new count();
        try{c.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }   
}

class count{
    public void run() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        char[][] arrHolder=new char[2*t][];
        for(int i=0;i<t;i++){
            int[] a=new int[2];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){a[j]=Integer.parseInt(parts[j]);}
            char[] arr=new char[a[0]];
            char[] arr1=new char[a[1]];
            String str=br.readLine();
            arr=str.toCharArray();
            arrHolder[2*i]=arr;     
            String str1=br.readLine();
            arr1=str1.toCharArray();
            arrHolder[2*i+1]=arr1;
        }
        for(int i=0;i<t;i++){
            check(String.valueOf(arrHolder[2*i]),String.valueOf(arrHolder[2*i+1]));
        }
    }

    public void check(String x,String s){
        String x0=x;
        String x1=x0+x0;
        String x2=x1+x1;
        String x3=x2+x2;
        String x4=x3+x3;
        String x5=x4+x4;
        int ans=-1;
        if(compute(s,x0)){ans=0;}
        else if(compute(s,x1)){ans=1;}
        else if(compute(s,x2)){ans=2;}
        else if(compute(s,x3)){ans=3;}
        else if(compute(s,x4)){ans=4;}
        else if(compute(s,x5)){ans=5;}
        System.out.println(ans);
    }
        
    public boolean compute(String s, String x){
        if(s.length()>x.length()){return false;}
        for(int i=0;i<x.length()-s.length()+1;i++){
            if(x.substring(i,i+s.length()).equals(s)){return true;}
        }
        return false;
    }
}
