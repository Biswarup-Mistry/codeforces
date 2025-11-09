/*import java.io.*;
import java.util.*;

public class D_Locked_Out {
    public static void main(String[] args) throws IOException {
        new Cost().run();
    }
}
*/
/*
class Cost {
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for (int _case = 0; _case < t; _case++) {
            String[] parts = br.readLine().split(" ");
            int n = Integer.parseInt(parts[0]);
            int[] a = new int[n];
            String[] items = br.readLine().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(items[i]);
            arrHolder[_case]=a;
        }
        int[] output=new int[t];
        for(int i=0;i<t;i++){solve(arrHolder[i],output,i);}
        for(int i=0;i<t;i++){System.out.println(output[i]);}
    }

    public void solve(int[] a,int[] output,int k) {
        int i=0;int j=1;int count=0;
        while(j<a.length){
            if(a[j]-a[i]==1){
                count++;
                j++;
            }
            else{i=j;j++;}
        }
        output[k]=count;
    }
}
*/
