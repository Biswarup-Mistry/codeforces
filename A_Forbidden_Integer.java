import java.io.*;
import java.util.*;

public class A_Forbidden_Integer{
    public static void main(String[] args) throws IOException{
        Forbidden f=new Forbidden();
        try{f.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class Forbidden{
    public void run()throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int j=0;j<t;j++) {
            String[] parts=br.readLine().split(" ");int[] a=new int[parts.length];
            for(int i=0;i<parts.length;i++) a[i]=Integer.parseInt(parts[i]);
            arrHolder[j]=a;
        }
        for(int i=0;i<t;i++) solve(arrHolder[i]);
    }
    public void solve(int[] a){
        int n=a[0];int k=a[1]; int x=a[2];int count=0;int sum=0;
        if(x!=1){System.out.println("YES");System.out.println(n);for(int i=0;i<n;i++){System.out.print(1+" ");}System.out.println();}
        else{
            if(k==1||(k==2 && n%2==1)){System.out.println("NO");}
            else{
                System.out.println("YES");
                if(n%2==0){System.out.println(n/2);for(int i=0;i<n/2;i++){System.out.print(2+" ");}System.out.println();}
                else{System.out.println((n-3)/2+1);for(int i=0;i<(n-3)/2;i++)System.out.print(2+" ");System.out.print(3+"\n");
                }
            }
        }
    }
}