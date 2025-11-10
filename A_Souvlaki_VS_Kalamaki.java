import java.io.*;
import java.util.*;

public class A_Souvlaki_VS_Kalamaki{
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
            check(arrHolder[i]);
        }
    }
    public void check(int[] a){
        int count=1;
        Arrays.sort(a);
        for(int i=0;i<a.length-1;i++){
            if((i%2!=0) && (a[i]!=a[i+1])){
                count=0;//break;
            }
        }
        if(count==1){System.out.println("YES");}
        else{System.out.println("NO");}
    }
 
}