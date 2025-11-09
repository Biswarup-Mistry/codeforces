/*import java.io.*;
import java.util.*;

public class C_Loyalty{
    public static void main(String[] args) throws IOException{
        Cost c=new Cost();
        try{c.run();}catch(Exception e){System.out.println("The exception is : "+e);}
    }
}

class Cost{
    public void run() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int[][] arrHolder=new int[2*t][];
        for(int i=0;i<t;i++){
            int[] b=new int[2];
            String[] parts1=br.readLine().split(" ");
            b[0]=Integer.parseInt(parts1[0]);
            b[1]=Integer.parseInt(parts1[1]);
            int[] arr=new int[b[0]];
            String[] parts=br.readLine().split(" ");
            for(int j=0;j<parts.length;j++){arr[j]=Integer.parseInt(parts[j]);}
            arrHolder[2*i]=b;//arr;
            arrHolder[2*i+1]=arr;
        }
        for(int i=0;i<t;i++){
            loyalty_Check(arrHolder[2*i],arrHolder[2*i+1]);
        }
    }
    public void loyalty_Check(int[] b,int[] a){
        Arrays.sort(a);
        for (int i = 0; i < a.length / 2; i++) {
            int t = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = t;
        }
        int sum = 0;   // total spent so far
        int bonus = 0; // total bonus points earned
        int x=b[1];
        for (int i = 0; i < a.length; i++) {
            int oldLevel = Math.floorDiv(sum, x);
            sum += a[i];
            int newLevel = Math.floorDiv(sum, x);
            if (newLevel > oldLevel) {
                bonus += a[i]; // earn bonus when loyalty increases
            }
        }
        System.out.println(bonus);
        for(int i=0;i<a.length;i++){System.out.print(a[i]+" ");}System.out.println();
    }
}*/

import java.io.*;
import java.util.*;

public class C_Loyalty {
    public static void main(String[] args) throws IOException {
        new Cost().run();
    }
}

class Cost {
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int _case = 0; _case < t; _case++) {
            String[] parts = br.readLine().split(" ");
            int n = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);
            int[] a = new int[n];
            String[] items = br.readLine().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(items[i]);

            solve(n, x, a);
        }
    }

    void solve(int n, int x, int[] a) {
        long totalSum = 0;
        for (int v : a) totalSum += v;
        int k = (int) (totalSum / x);  // number of loyalty level increases possible

        // Separate top-k items and the rest
        Integer[] arr = Arrays.stream(a).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder()); // sort descending
        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i < k) big.add(arr[i]);
            else small.add(arr[i]);
        }
        Collections.sort(big, Collections.reverseOrder()); // largest to smallest
        Collections.sort(small); // smallest to largest

        // Construct optimal purchase order
        List<Integer> order = new ArrayList<>();
        long S = 0;
        int idx = 0; // index for small fillers
        for (int b : big) {
            long target = ((S / x) + 1) * x;
            long need = Math.max(0, target - (S + b));

            // Add smallest fillers until we meet the requirement
            long sumFill = 0;
            while (idx < small.size() && sumFill < need) {
                order.add(small.get(idx));
                sumFill += small.get(idx);
                idx++;
            }

            // Add the big item that triggers the loyalty increase
            order.add(b);
            S += sumFill + b;
        }

        // Add any remaining small items
        while (idx < small.size()) order.add(small.get(idx++));

        // Calculate bonus points (to verify correctness)
        long sum = 0, bonus = 0;
        for (int price : order) {
            long oldLevel = sum / x;
            sum += price;
            long newLevel = sum / x;
            if (newLevel > oldLevel) bonus += price;
        }

        // Output
        System.out.println(bonus);
        for (int i = 0; i < order.size(); i++) {
            System.out.print(order.get(i));
            if (i < order.size() - 1) System.out.print(" ");
        }
        System.out.println();
    }
}

