import java.io.*;
import java.util.*;

public class a4{
    public static void main(String[] args) throws IOException{
        Homework h=new Homework();
        try{h.run();}
        catch (Exception e){System.out.println("The Exception is : "+e);}
    }
}

class Homework{
    public void run() throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        char[][] arrHolder=new char[3*t][];
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            char[] a=new char[n];
            String str=br.readLine();
            a=str.toCharArray();
            arrHolder[3*i]=a;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
            int m=Integer.parseInt(br.readLine());
            char[] b=new char[m];
            str=br.readLine();
            b=str.toCharArray();
            arrHolder[3*i+1]=b;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
            char[] c=new char[m];
            str=br.readLine();
            c=str.toCharArray();
            arrHolder[3*i+2]=c;
        }
        for(int i=0;i<t;i++){//< - - t{m(m+n)+n}=O(tm^2)=10^5(<10^8)
            char[] s1=arrHolder[3*i];
            char[] s2=arrHolder[3*i+1];
            char[] c=arrHolder[3*i+2];
            arrHolder[3*i]=checking(s1,s2,c);
        }
        for (int i=0;i<t;i++){
            System.out.print(arrHolder[3*i]);
            System.out.println();
        }  
    }

    public char[] checking(char[] s1,char[] s2,char[] c){
        char[] arr=new char[s1.length+s2.length];
        for(int j=0;j<s1.length;j++){arr[j]=s1[j];}//< - - O(n)
        for(int i=0;i<c.length;i++){//< - - O(m)
            if((c[i]=='D')||(c[i]=='d')){
                int k=0;
                while(arr[k]!=0){k++;}//< - - O(m+n)
                arr[k]=s2[i];
            }
            else{
                arr=shift(arr);//< - - 3C(m+n)
                arr[0]=s2[i];
            }
        }
        return arr;
    }

    public char[] shift(char[] arr){//< - - 3C(m+n)
        int k=0;
        while(arr[k] != 0){k++;}//< - - O(m+n)
        char[] a=new char[k];
        for (int i=0;i<a.length;i++){a[i]=arr[i];} //< - - O(m+n)
        for(int i=0;i<a.length;i++){arr[i+1]=a[i];} arr[0]=0;//< - - shift, O(m+n)
        return arr;
    }
}