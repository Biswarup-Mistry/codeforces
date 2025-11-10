import java.io.*;
import java.util.*;

public class Loyalty{
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
 