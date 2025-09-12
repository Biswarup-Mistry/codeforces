/*2131A Lever  , my time complexity = O(tn+tnk)=>O(tn(k+1))=>O(tn)=10^4<2.10^4*/

import java.io.*;
import java.util.*;

public class a7 {
    public static void main(String[] args) throws IOException{
        Lever l=new Lever();
        try{l.run();} //O(tn+tnk)
        catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class Lever{
    public void run()throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[2*t][];
        for(int i=0;i<2*t;i+=2){ //O(t*n)
            int n=Integer.parseInt(br.readLine());
            String[] parts=br.readLine().split(" ");
            int[] a=new int[/*n*/parts.length];
            for(int j=0;j<parts.length;j++){a[j]=Integer.parseInt(parts[j]);} //O(n)
            arrHolder[i]=a;
            parts=br.readLine().split(" ");
            int[] b=new int[/*n*/parts.length];
            for(int j=0;j<parts.length;j++){b[j]=Integer.parseInt(parts[j]);} //O(n)
            arrHolder[i+1]=b;
        }
        for(int i=0;i<2*t;i+=2){//O(tnk)
            run1(arrHolder[i],arrHolder[i+1]); 
        }
    }

    public void run1(int[] a,int[] b){ //O(kn)
        int i=0;
        int count=1;
        boolean step1=true;
        while (step1==true) {
            i=0;
            step1=false;
            while(i<a.length){
                if(a[i]>b[i]){a[i]--;count++;step1=true;}
                else if(a[i]<b[i]){a[i]++;}
                i++;
            }
        }
        System.out.println(count);
    }
}