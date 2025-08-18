//myOwnSolution1 : couldn't pass test case 5 due to time limit exceed in codeforces
import java.util.Scanner;
     
public class myOwnSolution1{
    public static void main(String[] args) {
        Array a=new Array();
        try{a.run();}
        catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}
     
class Array {
    void run(){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[][] arrayHolder=new int[2*t][];
        for (int k=0;k<t;k++){
            int n=sc.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];
            for (int i=0;i<n;i++){ //getting inputs
                a[i]=sc.nextInt();
            }
            for (int i=0;i<n;i++){
                b[i]=sc.nextInt();
            }
            arrayHolder[2*k]=a; //array head adding of a1
            arrayHolder[2*k+1]=b;
        }
        int[] f_c=new int[t];
        for(int k=0;k<t;k++){
            int f_a=f_of(arrayHolder[2*k],arrayHolder[2*k].length);
            int f_b=f_of(arrayHolder[2*k+1],arrayHolder[2*k+1].length);
            f_c[k]=f_a+f_b;
            //System.out.println("f(a)="+f_a);
            //System.out.println("f(b)="+f_b);
            //System.out.println("f(c)="+f_c);
        }
        for(int k=0;k<t;k++){
            int j=0;
            while(j<arrayHolder[2*k].length){
                f_c[k]=Dron(arrayHolder[2*k], arrayHolder[2*k+1], j, arrayHolder[2*k].length, f_c[k]);
                j++;
            }
        }
            
        for (int k=0;k<t;k++){
            System.out.println(f_c[k]);
            for (int i=0;i<arrayHolder[2*k].length;i++){
                System.out.print(arrayHolder[2*k][i]+" ");
            }
            System.out.println();
            for (int i=0;i<arrayHolder[2*k+1].length;i++){
                System.out.print(arrayHolder[2*k+1][i]+" ");
            }
            System.out.println();
        }     
        sc.close();
    }
     
    public int Dron(int a[],int b[],int i,int n,int f_c) {
        if ((a[i]!=b[i]) && (i<n)){
            swap(a,b,i);
            if (f_of(a,a.length)+f_of(b,b.length)>f_c){
                f_c=f_of(a,a.length)+f_of(b,b.length);
                f_c=Dron(a,b,i,n,f_c);
            }
            else{
                swap(a,b,i);
                i++;
            }   
        }
        return f_c;
    }
     
     
    public void swap(int a[],int b[],int i){ //swaping function
        int k=a[i]; 
        a[i]=b[i];
        b[i]=k;
    }
     
     
    public int f_of(int arr[],int n){ //count function
        int max=0;
        int sum=0;
        for (int i=0;i<n;i++){if (arr[i]>max){max=arr[i];}} //getting max
        int[] count=new int[max+1];
        for (int i=0;i<=max;i++){count[i]=0;} //filling every index of "count" with 0
        for(int i=0;i<n;i++){
            count[arr[i]]+=1;
        }
        for(int i=0;i<=max;i++){if(count[i]!=0) sum+=1;}
        return sum;
    }
}
