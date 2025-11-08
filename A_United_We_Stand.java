import java.io.*;
import java.util.*;

public class A_United_We_Stand{
    public static void main(String[] args) throws IOException{
        Cost c=new Cost();
        try{c.run();}catch(Exception e){System.out.println("The exception is : "+e);}
    }
}

class Cost{
    public void run() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] arr=new int[n];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){arr[j]=Integer.parseInt(parts[j]);}
            arrHolder[i]=arr;
        }
        for(int i=0;i<t;i++){
            check(arrHolder[i]);
        }
    }
    public void check(int[] a){
        int[] b=new int[a.length];
        int[] c=new int[a.length];
        int max=a[0];
        for(int i=1;i<a.length;i++){
            if(max<a[i]){max=a[i];}
        }
        int m=0;int k=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=max){
                b[k]=a[i];
                k++;
            }
            else{
                c[m]=a[i];
                m++;
            }
        }
        int countb=0;int countc=0;
        for(int i=0;i<a.length;i++){
            if(b[i]!=0){countb++;}if(c[i]!=0){countc++;}
        }
        if(countb==0 || countc==0){System.out.println("-1");}
        else{
            System.out.println(countb+" "+countc);
            for(int i=0;i<b.length;i++){if(b[i]!=0){System.out.print(b[i]+" ");}}System.out.println();
            for(int i=0;i<c.length;i++){if(c[i]!=0){System.out.print(c[i]+" ");}}System.out.println();
        }

    }
}