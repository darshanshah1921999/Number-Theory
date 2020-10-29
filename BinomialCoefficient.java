// Given q queries of type n k calculate c(n,k)%p where p>n
// nck = n!/k!(n-k)!
// if we want %p so nck = (n!)%p/((k!)%p * ((n-k)!)%p)
// First we have to precalculate n! % p..so we get it directly n!%p in o(1)

import java.util.*;

class BinomialCoefficient{
    static int f[] = new int[1000001];
    static int p = 1000000007;
    static int inv(int x){
        return power(x,p-2);//femat's little theoram
    }
    static int power(int a,int b){
        int res = 1;
        while(b>0){
            if(b%2==1){
                res = (int)((res *1L* a)%p);
            }
            b = b/2;
            a = (int)((a * 1L* a)%p);
        }
        return res;
    }
    static int c(int n,int k){
        if(k>n) return 0;
        int res = f[n];
        // res = res / f[k];//result not work becuse modulo in devision not working
        res = (int)((res *1L* inv(f[k]))%p);
        res = (int)((res *1L* inv(f[n-k]))%p);
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        f[0] = f[1] = 1;
        
        for(int  i=2;i<=1000000;i++){
            f[i] = (int)((f[i-1] * 1L * i)%p);
        }
        int q = sc.nextInt();
        while(q-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(c(n,k));
        }
    }
}