import java.io.*;
import java.util.*;

public class A_Round_Trip{
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
            int[] arr=new int[4];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){arr[j]=Integer.parseInt(parts[j]);}

            int[] part=new int[arr[arr.length-1]];
            String[] parts1=br.readLine().split("");
            for(int j=0;j<parts1.length;j++){part[j]=Integer.parseInt(parts1[j]);}
            arrHolder[2*i]=arr;
            arrHolder[2*i+1]=part;
        }
        int[] output=new int[t];
        
        /*for(int i=0;i<2*t;i++){
            for(int j=0;j<arrHolder[i].length;j++){System.out.print(arrHolder[i][j]+" ");}
            System.out.println();
        }*/
        for(int i=0;i<t;i++){
            check(arrHolder[2*i],arrHolder[2*i+1],output,i);
        }
        for(int i=0;i<t;i++){System.out.println(output[i]);}
    }
    public void check(int[] a,int[] b,int[] output,int i){
        
        int r=a[0];//-'0';//Character.getNumericValue(a[0]);//a[0];
        int x=a[1];//-'0';//Character.getNumericValue(a[1]);//a[1];
        int R0=r;
        int D=a[2];
        //System.out.println("a[0]="+a[0]+"a[1]="+a[1]);
        int count=0;
        if(r<x){output[i]=b.length;}
        else if (r>=x){
            for(int j=0;j<b.length;j++){
                if(b[j]==1){count++;R0=R0-D;}
                else if(b[j]==2 && R0<x){count++;R0=R0-D;}
                //else if(b[i+1]==1){count++;}
            }
            //if(count!=0){output[i]=count;}
            output[i]=count;
        }
        
    }
}