import java.io.*;
import java.util.*;

public class B_Even_Modulo_Pair{
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
            int n=Integer.parseInt(br.readLine());
            int[] a=new int[n];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){a[j]=Integer.parseInt(parts[j]);}
            arrHolder[i]=a;
        }
        int[][] output=new int[t][];
        
        /*for(int i=0;i<t;i++){
            for(int j=0;j<arrHolder[i].length;j++){System.out.print(arrHolder[i][j]+" ");}
            System.out.println();
        }*/
        for(int i=0;i<t;i++){
            check(arrHolder[i],output,i);
        }
        for(int i=0;i<t;i++){
            for(int j=0;j<output[i].length;j++){
                if(output[i][j]==-1){System.out.print(-1);break;}
                System.out.print(output[i][j]+" ");
                
            }
            System.out.println();
        }
    }
    public void check(int[] a,int[][] output,int p){
        output[p]=new int[2];
        //int k=0;
        output[p][0]=-1;
        output[p][1]=-1;
        for(int i=0;i<a.length-1;i++){
            if(output[p][0]==-1){
                int j=i+1;
                int l=0;
                //int a=a[i];
                //if(a[i]!=1){
                    while(j<a.length && l==0){
                        int m=a[j]%a[i];
                        //System.out.println("i = "+i+" j = "+j+" m = "+m);
                        if(m%2==0 && l==0){
                            output[p][0]=a[i];
                            output[p][1]=a[j];
                            l=1;//break;
                        }
                        j++;
                    }//break;
                //}
            }
        }
    }
}