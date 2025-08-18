import java.io.*;
import java.util.*;

public class testClassCGP {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(bf.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(bf.readLine());

            int[] a = new int[n];
            int[] b = new int[n];

            // read array a
            StringTokenizer stA = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(stA.nextToken());
            }

            // read array b
            StringTokenizer stB = new StringTokenizer(bf.readLine());
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(stB.nextToken());
            }

            // greedy swap: ensure a[i] <= b[i]
            for (int i = 0; i < n; i++) {
                if (a[i] > b[i]) {
                    int temp = a[i];
                    a[i] = b[i];
                    b[i] = temp;
                }
            }

            // compute distinct counts
            int f_a = distinctCount(a);
            int f_b = distinctCount(b);

            out.println(f_a + f_b);
            for (int x : a) out.print(x + " ");
            out.println();
            for (int x : b) out.print(x + " ");
            out.println();
        }

        out.flush();
    }

    static int distinctCount(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);
        return set.size();
    }
}

