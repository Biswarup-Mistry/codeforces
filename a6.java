//Codeforces Problem : 1901A - Line Trip 
//LineTrip my time complexity is (O(tn)~=O(5*10^4))<(O(n^3)=O(1.25*10^5))

import java.util.*;
import java.io.*;

public class a6 {
    public static void main(String[] args) throws IOException{
        LineTrip lp=new LineTrip();
        try{lp.run();}
        catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class LineTrip{
    public void run()throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[2*t][];
        for(int i=0;i<2*t;i++){ //O(t*n)
            String[] parts=br.readLine().split(" ");
            int[] a=new int[parts.length];
            for(int j=0;j<parts.length;j++){a[j]=Integer.parseInt(parts[j]);} //O(n)
            arrHolder[i]=a;
        }
        for(int i=0;i<t;i++){ //O(t*n)
            run1(arrHolder[2*i+1],arrHolder[2*i][arrHolder[2*i].length-1]); //O(n)
        }
    }
    public void run1(int[] a,int x){
        int[] d=new int[a.length+1];
        for(int i=0;i<a.length;i++){ //O(n)
            d[i]=a[i];
        }
        d[d.length-1]=x;
        int[] c=new int[d.length];
        int k=1;
        c[0]=d[0];
        while(k<d.length){//O(n)
            c[k]=d[k]-d[k-1];
            k+=1;
        }
        c[c.length-1]=2*c[c.length-1];
        System.out.println(max(c)); //O(n)
    }
    public int max(int[] d){
        int max=0;
        for(int i=0;i<d.length;i++){if(max<d[i]){max=d[i];}} //O(n)
        return max;
    }
}