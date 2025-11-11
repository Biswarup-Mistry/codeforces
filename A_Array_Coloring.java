import java.io.*;
import java.util.*;

public class A_Array_Coloring{
    public static void main(String[] args) throws IOException{
        RT r=new RT();
        try{r.run();}catch(Exception e){System.out.println("The exception is : "+e);}
    }
}

class RT{
    public void run() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] a=new int[n];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){a[j]=Integer.parseInt(parts[j]);}
            arrHolder[i]=a;
        }
        for(int i=0;i<t;i++){
            solve(arrHolder[i]);
        }
    }
    public void solve(int[] a){
        List<Integer> arr = new ArrayList<>();
        for(int x: a){arr.add(x);}
        int hasEven=0;
        int hasOdd=0;
        for(int x: arr)if(x%2==0)hasEven++;else hasOdd++;
        if(hasOdd%2==0 && hasEven%2==0) System.out.println("YES");
        else if(hasOdd%2!=0)System.out.println("NO");
        else System.out.println("YES");
    }
}