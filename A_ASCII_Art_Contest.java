import java.io.*;
import java.util.*;

public class A_ASCII_Art_Contest{
    public static void main(String[] args) throws Exception{
        Art a=new Art();
        try{a.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class Art{
    public void run()throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] parts=br.readLine().split(" ");
        int[] a=new int[3];
        for(int i=0;i<a.length;i++){a[i]=Integer.parseInt(parts[i]);}
        int min = Arrays.stream(a).min().getAsInt();
        int max = Arrays.stream(a).max().getAsInt();
        if(max-min>=10){System.out.println("check again");}
        else{
            Arrays.sort(a);
            System.out.println("final "+a[1]);
        }
    }
}