import java.util.Scanner;


public class Main {
    public static void main(String args[]) {
        ArrayHandler a = new ArrayHandler();
        try {
            a.run();
        } catch (Exception e) {
            System.out.println("The Exception is :=> " + e);
        }
    }
}


class ArrayHandler {
    void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // number of test cases
        int[][] arrayHolder = new int[2 * t][];

        if (t >= 1 && t <= 10000) {
            int n;
            for (int i = 0; i < t; i++) {
                n = sc.nextInt();
                if (n >= 1 && n <= 100000) {
                    int[] a1 = new int[n];
                    int[] a2 = new int[n];
                    for (int j = 0; j < n; j++) a1[j] = sc.nextInt();
                    for (int j = 0; j < n; j++) a2[j] = sc.nextInt();
                    arrayHolder[2 * i] = a1;
                    arrayHolder[2 * i + 1] = a2;
                }
            }
        }

        // Swap elements to ensure a1[j] >= a2[j]
        int i = 0;
        while (i < 2 * t) {
            if (arrayHolder[i] != null && arrayHolder[i + 1] != null) {
                for (int j = 0; j < arrayHolder[i].length; j++) {
                    if (arrayHolder[i][j] < arrayHolder[i + 1][j]) {
                        int a = arrayHolder[i][j];
                        arrayHolder[i][j] = arrayHolder[i + 1][j];
                        arrayHolder[i + 1][j] = a;
                    }
                }
            }
            i += 2;
        }

        // Find and print max for each pair
        for (i = 0; i < 2 * t; i += 2) {
            if (arrayHolder[i] != null && arrayHolder[i + 1] != null) {
                int[] a1 = arrayHolder[i];
                int[] a2 = arrayHolder[i + 1];
                int max1 = Integer.MIN_VALUE;
                int max2 = Integer.MIN_VALUE;
                for (int j = 0; j < a1.length; j++) {
                    if (a1[j] > max1) max1 = a1[j];
                    if (a2[j] > max2) max2 = a2[j];
                }
                System.out.println(max1 + max2);
            }
        }

        sc.close();
    }
}

