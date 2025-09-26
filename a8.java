import java.util.*;
import java.io.*;

public class a8{
    public static void main(String[] args) throws IOException{
        Cover_in_Water c=new Cover_in_Water();
        try{c.run();}
        catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class Cover_in_Water{
    public void run() throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        char[][] arrHolder=new char[t][];
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            char[] a=new char[n];
            String str=br.readLine();
            a=str.toCharArray();
            arrHolder[i]=a;
        }
        for(int i=0;i<t;i++){
            cnt(arrHolder[i]);
        }
    }
    public void cnt(char[] a){
        boolean count=false;
        int empty=0;
        for(int i=0;i<a.length;i++){
            if((i+1<a.length && i+2<a.length) && a[i]=='.' && a[i+1]=='.' && a[i+2]=='.'){count=true;break;} 
            if(a[i]=='.'){empty++;}
        }
        if(count==true){System.out.println("2");}
        else{System.out.println(empty);}
    }
}