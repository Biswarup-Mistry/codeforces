//public class CGPSolution {
//chatGPT solution

import java.io.*;
import java.util.*;

public class CGPTSolution {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(fs.br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(fs.br.readLine().trim());
            int[] a = new int[n];
            int[] b = new int[n];

            // read a
            {
                StringTokenizer st = new StringTokenizer(fs.br.readLine());
                for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());
            }
            // read b
            {
                StringTokenizer st = new StringTokenizer(fs.br.readLine());
                for (int i = 0; i < n; i++) b[i] = Integer.parseInt(st.nextToken());
            }

            // Sets of distinct values achieved so far for each array
            HashSet<Integer> seenA = new HashSet<>();
            HashSet<Integer> seenB = new HashSet<>();

            // Track indices with x!=y to process later
            ArrayList<Integer> diff = new ArrayList<>();

            // Pass 0: fix (v,v) pairs; they add v to both sides
            for (int i = 0; i < n; i++) {
                if (a[i] == b[i]) {
                    seenA.add(a[i]);
                    seenB.add(b[i]);
                } else {
                    diff.add(i);
                }
            }

            // Pass 1: try to add two new distincts with one index
            ArrayList<Integer> rem = new ArrayList<>();
            for (int i : diff) {
                int x = a[i], y = b[i];
                // try keep (x -> A, y -> B)
                if (!seenA.contains(x) && !seenB.contains(y)) {
                    seenA.add(x);
                    seenB.add(y);
                }
                // else try swap (y -> A, x -> B)
                else if (!seenA.contains(y) && !seenB.contains(x)) {
                    // swap
                    int tmp = a[i]; a[i] = b[i]; b[i] = tmp;
                    seenA.add(a[i]); // now a[i]==y
                    seenB.add(b[i]); // now b[i]==x
                } else {
                    rem.add(i);
                }
            }

            // Pass 2: try to add one new distinct per leftover pair
            ArrayList<Integer> rem2 = new ArrayList<>();
            for (int i : rem) {
                int x = a[i], y = b[i];
                boolean placed = false;

                // keep orientation if it adds one new
                if (!seenA.contains(x)) { seenA.add(x); placed = true; }
                else if (!seenB.contains(y)) { seenB.add(y); placed = true; }

                // otherwise try swapping if that adds one new
                else if (!seenA.contains(y)) {
                    int tmp = a[i]; a[i] = b[i]; b[i] = tmp;
                    seenA.add(a[i]); placed = true;
                } else if (!seenB.contains(x)) {
                    int tmp = a[i]; a[i] = b[i]; b[i] = tmp;
                    seenB.add(b[i]); placed = true;
                }

                if (!placed) rem2.add(i); // nothing to gain; leave for final
            }

            // Pass 3: assign remaining as-is (no gain possible)
            // (arrays a,b already have their values)

            int answer = seenA.size() + seenB.size();
            out.println(answer);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) { if (i>0) sb.append(' '); sb.append(a[i]); }
            out.println(sb.toString());
            sb.setLength(0);
            for (int i = 0; i < n; i++) { if (i>0) sb.append(' '); sb.append(b[i]); }
            out.println(sb.toString());
        }

        out.flush();
    }
}

//}
