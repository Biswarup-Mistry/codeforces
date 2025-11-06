import java.io.*;
import java.util.*;

public class A_Sequence_Game{
    public static void main(String[] args) throws IOException{
        RT r=new RT();
        try{r.run();}catch(Exception e){System.out.println("The exception is : "+e);}
    }
}

class RT{
    public void run() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[2*t][];
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] a=new int[n];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){a[j]=Integer.parseInt(parts[j]);}
            int[] x=new int[1];
            x[0]=Integer.parseInt(br.readLine());
            arrHolder[2*i]=a;
            arrHolder[2*i+1]=x;
        }
        for(int i=0;i<t;i++){
            check(arrHolder[2*i],arrHolder[2*i+1][0]);
        }
    }
    public void check(int[] a,int x){
        if(min(a)<=x && x<=max(a)){System.out.println("YES");}
        else{System.out.println("NO");}
    }
    public int min(int[] a){
        int min=a[0];
        for(int i=1;i<a.length;i++){
            if(min>a[i]){min=a[i];}
        }return min;
    }
    public int max(int[] a){
        int max=a[0];
        for(int i=1;i<a.length;i++){
            if(max<a[i]){max=a[i];}
        }return max;
    }
}