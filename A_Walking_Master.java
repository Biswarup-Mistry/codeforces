 import java.io.*;
 import java.util.*;

 public class A_Walking_Master{
    public static void main(String[] args) throws IOException{
        InnerA_Walking_Master q=new InnerA_Walking_Master();
        try{q.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
 }

class InnerA_Walking_Master {
    public void run()throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int i=0;i<t;i++){
            int[] a=new int[4];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){a[j]=Integer.parseInt(parts[j]);}
            arrHolder[i]=a;
        }
        for(int i=0;i<t;i++){Solve(arrHolder[i]);}
    }
    public void Solve(int[] arr){
        int a=arr[0];
        int b=arr[1];
        int c=arr[2];
        int d=arr[3];
        int count=0;
        /*while(b!=d){a++;b++;count++;}
        if(a<c)System.out.println(-1);
        else{
            while(a!=c){a--;count++;}
            System.out.println(count);
        }//correct, but timelimit exceeded on test 2*/
        int k1=d-b; int k2=a+k1; 
        if(k1 < 0 || k2 < c)System.out.println(-1);
        else System.out.println(k1+k2-c);

    }
 }