import java.io.*;
import java.util.*;

public class a2{
    public static void main(String[] args) throws Exception {
        Array a = new Array();
        try{a.run();}
        catch(Exception e){System.out.println("The Exception is : "+e);}
    }
}

class Array {
    public void run() throws IOException{
        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
        //- - - - - - - - - - - - - - - [Taking inputs] - - - - - - - - - - - - - - - - 
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[][] arrayHolder=new int[2*t][];
        int[][] D=new int[2*t][];
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
        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
        //- - - - - - - - - - - - - - -[Closing taking inputs]- - - - - - - - - - - - - 
        
        for (int i=0;i<t;i++){
            int n=arrayHolder[2*i].length;
            int[] D_a=new int[2*n];
            int[] D_b=new int[2*n];
            for (int j=0;j<n;j++){
                D_a[arrayHolder[2*i][j]]+=1;
            }
            for (int j=0;j<n;j++){
                D_b[arrayHolder[2*i+1][j]]+=1;
            }
            D[2*i]=D_a;
            D[2*i+1]=D_b;
        }
        int[] f_c=new int[t];
        for(int i=0;i<t;i++){
            //f_c[i]=f_of(D[2*i])+f_of(D[2*i+1]);
            f_c[i]=realFunc(arrayHolder[2*i], arrayHolder[2*i+1], D[2*i], D[2*i+1], f_of(D[2*i])+f_of(D[2*i+1]));
        }

        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
        //- - - - - - - - - - - - - - -[pringting]- - - - - - - - - - - - - - - - - - - 
        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
        for (int k=0;k<t;k++){
            System.out.println(f_c[k]);
            for (int i=0;i<arrayHolder[2*k].length;i++){
                System.out.print(arrayHolder[2*k][i]+" ");
                //System.out.print(D[2*k][i]+" ");

            }
            /*System.out.println();
            for (int i=0;i<arrayHolder[2*k].length;i++){
            //    System.out.print(arrayHolder[2*k][i]+" ");
                System.out.print(D[2*k][i]+" ");

            }*/
            System.out.println();
            for (int i=0;i<arrayHolder[2*k+1].length;i++){
                System.out.print(arrayHolder[2*k+1][i]+" ");
                //System.out.print(D[2*k+1][i]+" ");
            }
            /*System.out.println();
            for (int i=0;i<arrayHolder[2*k+1].length;i++){
                //System.out.print(arrayHolder[2*k+1][i]+" ");
                System.out.print(D[2*k+1][i]+" ");
            }*/
            System.out.println();
        }
        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
        //- - - - - - - - - - - - - - -[pringting close]- - - - - - - - - - - - - - - - 
        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
        //- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
        sc.close();

    }
    public int realFunc(int a[],int b[],int D_a[],int D_b[],int f_c){
        int i=0;
        while(i<a.length){
            if(a[i]!=b[i]){
                swap(a,b,i);
                Dron(a[i],b[i],D_a,D_b);
                if(f_of(D_a)+f_of(D_b)>f_c){
                    f_c=f_of(D_a)+f_of(D_b);
                    
                }
                else{
                    swap(a,b,i);
                    Dron(a[i],b[i],D_a,D_b);
                    f_c=f_of(D_a)+f_of(D_b);
                }
            }
            i++;
        }
        return f_c;
    }
    public void Dron(int a, int b, int D_a[],int D_b[]){
        D_a[a]++;
        D_b[b]++;
        D_a[b]--;
        D_b[a]--;
    }
    public void swap(int a[],int b[],int i){
            int k=a[i];
            a[i]=b[i];
            b[i]=k;
    }
    public int f_of(int a[]){
        int sum=0;
        for(int i=0;i<a.length;i++){
            if (a[i]!=0){sum++;}
        }
        return sum;
    }
}