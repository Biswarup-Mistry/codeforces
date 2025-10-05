import java.util.*;
import java.io.*;

public class a11{
    public static void main(String[] args) throws Exception{
        DoremyP dp=new DoremyP();
        try{dp.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class DoremyP{
    public void run()throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int i=0;i<t;i++){
            int a=Integer.parseInt(br.readLine());
            int[] arr=new int[a];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){arr[j]=Integer.parseInt(parts[j]);} //O(n)
            arrHolder[i]=arr;
        }
        /*for(int i=0;i<t;i++){
            for(int j=0;j<arrHolder[i].length;j++){
                System.out.print(arrHolder[i][j]);
            }
            System.out.println();
        }*/

        for(int i=0;i<t;i++){check(arrHolder[i]);}
    }

    public void check(int[] arr){
        //int[] a=new int[10^5];
        int[] frequency=new int[100001];
        frequency=frequencyNo(arr,frequency);
        int f1=Frequency(frequency);
        int f_1=Frequency1(frequency);
        int f_2=Frequency2(frequency,f1);
        int F=0;
        for(int i=0;i<frequency.length;i++){
            if (frequency[i]!=0){F++;}
        }
        if(arr.length<=2){System.out.println("YES");}
        else{
            if(F>=3){System.out.println("NO");}
            else if((f_1 == f_2)|| Math.abs(f_1 - f_2)==1 && (arr.length%2==1) || F==1){System.out.println("YES");}
            else{System.out.println("NO");}
        }
    }
    public int[] frequencyNo(int[] arr,int[] frequency){
        for(int i=0;i<arr.length;i++){
            frequency[arr[i]]++;
        }
        return frequency;
    }
     public int Frequency(int[] frequency){
        int j=0;
        for(int i=0;i<frequency.length;i++){
            if(frequency[i]!=0){j=i;break;}
        }
        return j;
    }
    public int Frequency1(int[] frequency){
        int j=0;
        for (int i=0;i<frequency.length;i++){
            if(frequency[i]!=0){j=i;break;}
        }
        return frequency[j];
    }
    public int Frequency2(int[] frequency,int a){
        int j=0;
        for(int i=0;i<frequency.length;i++){
            if(frequency[i]!=0 && i!=a){j=i;break;}
        }
        return frequency[j];
    }
}