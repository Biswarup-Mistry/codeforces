import java.io.*;
import java.util.*;

public class A_Buttons{
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
            //int n=Integer.parseInt(br.readLine());
            int[] arr=new int[3];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){arr[j]=Integer.parseInt(parts[j]);}
            arrHolder[i]=arr;
        }
        for(int i=0;i<t;i++){
            check(arrHolder[i]);
        }
    }
    public void check(int[] n){
        int a=n[0];
        int b=n[1];
        int c=n[2];
        if(a==b){
            if(c%2!=0){System.out.println("First");}
            else{System.out.println("Second");}
        }
        else if(a<b){System.out.println("Second");}
        else{System.out.println("First");}
    }

}