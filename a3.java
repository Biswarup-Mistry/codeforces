import java.util.*;
import java.io.*;

public class a3{
    public static void main(String[] args) throws IOException{
        Code c=new Code();
        try{c.run();}
        catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }
}

class Code {
    public void run() throws IOException{
        FastReader fr=new FastReader();
        int t=fr.nextInt();
        int[][] arrHolder=new int[t][];
        int[] k=new int[t];
        for(int i=0;i<t;i++){
            int n=fr.nextInt();
            int p=fr.nextInt();
            k[i]=p;
            int[] arr=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=fr.nextInt();
            }
            arrHolder[i]=arr;
        }

        for (int i=0;i<t;i++){
            int[] b=new int[arrHolder[i].length];
            for(int j=0;j<arrHolder[i].length;j++){b[j]=arrHolder[i][j];}
            int low=0;
            mergeSort(b,low,b.length-1);            
            if(compareArrays(arrHolder[i],b) || k[i]>1){System.out.println("YES");}
            else{System.out.println("NO");}
          
        }
    }

    public static boolean compareArrays(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void mergeSort(int arr[], int l, int r){
        
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
    public void merge(int arr[], int l, int m, int r){
        
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}