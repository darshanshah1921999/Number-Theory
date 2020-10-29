//problem link:-https://www.spoj.com/problems/TDKPRIME/

import java.util.*;

class KthPrime{
    public static void main(String[] args) {
        int n = 90000000;
        int size = 6000000;
        // System.out.println(n);
        boolean isPrime[] = new boolean[n+1];
        int arr[] = new int[size+1];
        for(int i=2;i*i<=n;i++){
            if(!isPrime[i]){
                for(int j=i*i;j<=n;j=j+i){
                    isPrime[j] = true;
                }
            }
        }
        int j = 0;
        for(int i=2;i<n;i++){
            if(!isPrime[i]){
                arr[j]=i;
                j++;
            }
        }
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while(q-->0){
            int temp = sc.nextInt();
            System.out.println(arr[temp-1]);
        }
    }
}