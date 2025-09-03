import java.util.*;
import java.io.*;

public class a5{ //O(4 * 10^3)<10^8;O(Ct)=O(t)
    public static void main (String[] args) throws IOException{
        inTheDream ind=new inTheDream();
        try{ind.run();}
        catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class inTheDream{
    public void run() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[t][];
        for(int i=0;i<t;i++){ //O(t)
            String[] parts = br.readLine().split(" ");  // split the line by space
            int[] a = new int[parts.length];
            for (int j = 0; j < parts.length; j++) { //O(4)
                a[j] = Integer.parseInt(parts[j]); // convert each part to int
            }
            arrHolder[i]=a;
        }
        for (int i=0;i<t;i++){ //O(t)
            if((min(arrHolder[i][0],arrHolder[i][1])+1)*2>=max(arrHolder[i][0],arrHolder[i][1])){ //O(1)
                int a=arrHolder[i][2]-arrHolder[i][0]; //O(1)
                int b=arrHolder[i][3]-arrHolder[i][1]; //O(1)
                if((min(a,b)+1)*2>=max(a,b)){System.out.println("YES");} //O(1)
                else{System.out.println("NO");} //O(1)
            }
            else{System.out.println("NO");} //O(1)
        }
    }
    public int min(int a,int b){int min=0;if(a<b){min=a;}else{min=b;}return min;} //O(1)
    public int max(int a,int b){int max=0;if(a<b){max=b;}else{max=a;}return max;} //O(1)
}