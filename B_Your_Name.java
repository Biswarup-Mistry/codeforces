import java.io.*;
import java.util.*;

public class B_Your_Name{
    public static void main(String[] args) throws IOException{
        Cost c=new Cost();
        try{c.run();}catch(Exception e){System.out.println("The exception is : "+e);}
    }
}

class Cost{
    public void run() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        String[][] arrHolder=new String[t][];
        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            String[] parts=br.readLine().split(" ");
            String[] p=new String[2];int k=0;
            for(String x:parts){
                p[k]=x;k++;
            }
            arrHolder[i]=p;
        }
        for(int i=0;i<t;i++){
            check(arrHolder[i][0],arrHolder[i][1]);
        }

    }
    public void check(String s1, String s2){
        List<Character> list1=new ArrayList<>();
        List<Character> list2=new ArrayList<>();
        for(char ch:s1.toCharArray())list1.add(ch);
        for(char ch:s2.toCharArray())list2.add(ch);
        int f=1;
        Map<Character, Integer> freq1 = new HashMap<>();
        for (char c : list1) {
            freq1.put(c, freq1.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> freq2 = new HashMap<>();
        for (char c : list2) {
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
        }
        if(freq1.equals(freq2))System.out.println("YES");
        else System.out.println("NO");
    }
}