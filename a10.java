import java.util.*;
import java.io.*;

public class a10{
    public static void main(String[] args) throws IOException{
        jswap js=new jswap();
        try{js.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class jswap {
    public void run() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            String[] parts=br.readLine().split(" ");
            int[] a=new int[parts.length];
            for(int j=0;j<parts.length;j++){a[j]=Integer.parseInt(parts[j]);} //O(n)
            arrHolder[i]=a;
        }
        for(int i=0;i<t;i++){
            check(arrHolder[i][0]);
        }
    }
    
    public void check(int n){
        if(n==1){System.out.println("YES");}
        else{System.out.println("NO");}
    }
}