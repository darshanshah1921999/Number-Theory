//print prime factors of number 
//100-> 2^2, 5^2
//brute force:- start with  2 and go through n and if  it n%i==0 then take count variable for  how time that elemen occur's here 2 is 
//              comes 2 time so count stores 2 and we devide number 2 times means ineer while loop for how many times it occur.

//observation:- If n is composite number it means at least 1 prime divisor of n below sqrt(n)
import java.util.*;

class PrimeFactors{
    //brute force
    //worst case when n  is prime then run for all time
    static void PrimeFact(int n){
        for(int i=2;i<=n;i++){
            if(n%i==0){
                int cnt=0;
                while(n%i==0){
                    cnt++;
                    n = n/i;
                }
                System.out.println(i+"^"+cnt);
            }
        }
    }

    //complexity-sqrt(n)
    static void PrimeFactOptimize(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                int cnt=0;
                while(n%i==0){
                    cnt++;
                    n = n/i;
                }
                System.out.println(i+"^"+cnt);
            }
        }
        if(n>1){
            System.out.println(n+"^"+1);
        }
    }

    //using seive -> 

    static void preprocessing(int arr[],int n){
        for(int i=1;i<=n;i++){
            arr[i] = -1;
        }
        for(int i=2;i*i<=n;i++){
            if(arr[i]==-1){
                for(int j=i;j<=n;j=j+i){
                    if(arr[j]==-1){
                        arr[j] = i;
                    }
                }
            }
        }
    }
    static void seive(int n){
        int arr[] = new int[n+1];
        preprocessing(arr,n);// it is use for once and for max length of array and then each factors we can get in logn time
        while(arr[n]!=-1){
            System.out.print(arr[n]+" ");
            n = n/arr[n];
        }
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PrimeFact(n);
        PrimeFactOptimize(n);
        seive(n);
    }
}