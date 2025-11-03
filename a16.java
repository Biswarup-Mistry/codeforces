import java.io.*;
import java.util.*;

public class a16{
    public static void main(String[] args) throws IOException{
        Cost c=new Cost();
        try{c.run();}catch(Exception e){System.out.println("The exception is : "+e);}
    }
}

class Cost{
    public void run() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[] arrHolder=new int[t];
        String[] parts=br.readLine().split(" ");
        for(int i=0;i<t;i++){
            arrHolder[i]=Integer.parseInt(parts[i]);
        }
        check(arrHolder);
    }
    public void check(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){arr[i]=arr[i]*(-1);}
        }
        int min=arr[0];
        for(int i=1;i<arr.length;i++){if(min>arr[i]){min=arr[i];}}
        System.out.println(min);
    }
}