import java.io.*;
import java.util.*;

public class a19{
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
            int[] b=new int[2];
            String[] parts1=br.readLine().split(" ");
            b[0]=Integer.parseInt(parts1[0]);
            b[1]=Integer.parseInt(parts1[1]);
            int[] arr=new int[b[0]];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){arr[j]=Integer.parseInt(parts[j]);}
            arrHolder[2*i]=b;//arr;
            arrHolder[2*i+1]=arr;
        }
        for(int i=0;i<t;i++){
            loyalty_Check(arrHolder[2*i],arrHolder[2*i+1]);
        }
    }
    public void loyalty_Check(int[] b,int[] a){
        Arrays.sort(a);
        int sum=0; int k=0;int p=0;int x=b[1];
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        int m=0;int j=a.length-1;
        while(m<=j){
            if((sum-a[j])/x != sum/x){
                sum-=a[j];
                p+=a[j];j--;
            }
            else{
                sum-=a[m];//p+=a[m];
                m++;
            }
        }
        System.out.println(p);
        for(int i=0;i<a.length;i++){System.out.print(a[i]+" ");}System.out.println();
    }
}
