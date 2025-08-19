import java.io.*;
import java.util.*;

public class Main1{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];

            String[] arrA = br.readLine().split(" ");
            String[] arrB = br.readLine().split(" ");

            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(arrA[i]);
                setA.add(a[i]);
            }
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(arrB[i]);
                setB.add(b[i]);
            }

            int fA = setA.size();
            int fB = setB.size();
            int maxDistinct = Math.min(n, fA + fB);

            out.append(maxDistinct).append("\n");

            // Just print original arrays (swapping not needed for max value)
            for (int x : a) out.append(x).append(" ");
            out.append("\n");
            for (int x : b) out.append(x).append(" ");
            out.append("\n");
        }
        System.out.print(out);
    }
}
