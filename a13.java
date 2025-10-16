import java.io.*;
import java.util.*;

public class a13{
    public static void main(String[] args) throws IOException{
        Cost c=new Cost();
        try{c.run();}catch(Exception e){System.out.println("The exception is : "+e);}
    }
}

class Cost{
    public void run() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[2*t][];
        for(int i=0;i<t;i++){
            int[] arr=new int[2];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){arr[j]=Integer.parseInt(parts[j]);}
            int[] arr1=new int[arr[0]];
            String[] parts1=br.readLine().split(" ");
            for(int j=0;j<parts1.length;j++){arr1[j]=Integer.parseInt(parts1[j]);}
            arrHolder[2*i]=arr;
            arrHolder[2*i+1]=arr1;
        }
        for(int i=0;i<t;i++){
            check(arrHolder[2*i][1],arrHolder[2*i+1]);
        }
    }
    
    public void check(int k,int[] n){
        Boolean ans=false;
        for(int i=0;i<n.length;i++){
            if(k==n[i]){ans=true;}
        }
        if(ans==true){System.out.println("YES");}
        else{System.out.println("NO");}
    }
}