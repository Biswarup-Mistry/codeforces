import java.io.*;
import java.util.*;

public class a9 {
    public static void main(String[] args) throws Exception{
        Game g=new Game();
        try{g.run();}catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class Game{
    public void run() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[] arrHolder=new int[t];
        for(int i=0;i<t;i++){
            arrHolder[i]=Integer.parseInt(br.readLine());;
        }
        for(int i=0;i<t;i++){
            check(arrHolder[i]);
        }
    }
    public void check(int n){
        if(n%3==0){System.out.println("Second");}
        else{System.out.println("First");}
    }
}
