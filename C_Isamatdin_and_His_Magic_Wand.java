import java.io.*;
import java.util.*;

public class C_Isamatdin_and_His_Magic_Wand{
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
            arrHolder[i]=solve(arrHolder[i]);
        }
        for(int i=0;i<t;i++){
            for(int x : arrHolder[i]){
                System.out.print(x+" ");
            }System.out.println();
        }
    }
    public int[] solve(int[] a){
        List<Integer> arr = new ArrayList<>();
        int[] res=new int[a.length];
        for(int x: a){arr.add(x);}
        int sum = 0;
        boolean hasEven=false;
        boolean hasOdd=false;
        for(int x : arr){
            if(x%2==0) hasEven=true;
            else hasOdd=true;
        }
        if(hasEven && hasOdd){
            Collections.sort(arr);
            for(int i=0;i<a.length;i++){res[i]=arr.get(i);}
        }
        else{
            for(int i=0;i<a.length;i++){res[i]=arr.get(i);}
        }
        return res;
    }
 
}