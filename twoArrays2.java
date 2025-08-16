import java.util.Scanner;

public class twoArrays2 {
    public static void main(String[] args) {
        Array a=new Array();
        try{a.run();}
        catch(Exception e){System.out.println("The Error is : "+e);}
    }
    
}

class Array{
    void run(){ //main run function
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] a=new int[n];
        int[] b=new int[n];
        for (int i=0;i<n;i++){ //getting inputs
            a[i]=sc.nextInt();
        }
        for (int i=0;i<n;i++){
            b[i]=sc.nextInt();
        }
        
        int f_a=f_of(a,n);
        int f_b=f_of(b,n);
        int f_c=f_a+f_b;
        /*System.out.println("f(a)="+f_a);
        System.out.println("f(b)="+f_b);
        System.out.println("f(c)="+f_c);*/
        
        for (int i=0;i<n;i++){ //main function to build
            if(a[i]!=b[i]){ //if a[i] and b[i] != same
                swap(a, b, i); //swaping
                f_a=f_of(a,n);
                f_b=f_of(b,n);
                if(f_a+f_b>f_c){
                    f_c=f_a+f_b;
                    System.out.println("F(c)="+f_c);
                }
            }
        }
        
        //System.out.println("AFTER SWAPING(if any)");
        //System.out.println("f(a)="+f_a);
        //System.out.println("f(b)="+f_b);
        //System.out.println("f(c)="+f_c);
        System.out.println(f_c);
        for (int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        for (int i=0;i<n;i++){
            System.out.print(b[i]+" ");
        }
        System.out.println();
        sc.close();
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