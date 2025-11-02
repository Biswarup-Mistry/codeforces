import java.io.*;
import java.util.*;

public class a15{
    public static void main(String[] args) throws IOException{
        Cost c=new Cost();
        try{c.run();}catch(Exception e){System.out.println("The exception is : "+e);}
    }
}

class Cost{
    public void run() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[] point=new int[t];
        char[][] arrHolder=new char[t*10][];
        for(int i=0;i<10*t;i++){
            String parts=br.readLine();
            char[] p=parts.toCharArray();
            arrHolder[i]=p;
        }
        for(int i=0;i<t;i++){
            //System.out.println("Checking Started for t = "+i);
            int l=10*i;//int b=10*(t+1);
            char[][] a=new char[10][10];
            for(int m=0;m<10;m++){
                for(int n=0;n<10;n++){
                    a[m][n]=arrHolder[l+m][n];
                }
            }
            check(a, point, i);
            //System.out.println("Checking Ended for t = "+i);
        }
        for(int i=0;i<t;i++){
            System.out.println(point[i]);
        }

    }
    public void check(char[][] arr, int[] p,int t){
        int sum=0;
        int a=0;int b=0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(arr[i][j]=='X'){
                    if(i>=5){a=9-i;}else{a=i;}
                    if(j>=5){b=9-j;}else{b=j;}
                    if(a<b||a==b){sum=sum+a+1;}
                    else{sum=sum+b+1;}
                }
            }
        }
        p[t]=sum;
    }
}