// Euler Totient Function(ETF) counts the number of positive integers upto n hihc are co-prime to number
// denotes phi(n) 
//phi(5) = 4...1,2,3,4 are gcd with 5 is 1 means coprime

//phi(2) = 1,phi(3)=2,phi(5)=4,phi(7)=6,phi(11)=10....means for prime so phi(p)=p-1 beacause p-1 all are coprime to p 

//phi(p^x)=? ...phi(2^5)=16,phi(3^5) = 162

//phi(p^x) = p^x - number of integrs not coprime with p
//         = p^x -  number of mulitiple of p => p^x - (p^x/p) => p^(x-1)(p-1)

// ----------------

//Multiplicative function
//an airthmetic function f(x) is called multiplicative if f(n*m) = f(n)*f(m) where gcd(n,m)=1

//ETF is multiplicative function so 
//n = p1^x1 * p2^x2...
//f(n) = f(p1^x1) * f(p2^x2)... 

//phi(p^x) = p^(x-1) * (p-1)..we get this formula above
//phi(n) = phi(p1^x10) * phi(p2^x2*)...
//       = p1^(x1-1)*(p1-1) * p2^(x2-1)*(p2-1)*..
//       = n*((p1-1)/p1 * (p2-1)/p2 *..)
 
//phi(6) = 6*(2-1)*(3-1)/2*3
import java.util.*;

class EulerTotientFunction{

    static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        else{
            return gcd(b,a%b);
        }
    }
    //brute force approach
    static int phi(int n){
        int cnt = 0;
        for(int i=1;i<=n;i++){
            if(gcd(i,n)==1){
                cnt++;
            }
        }
        return cnt;
    }
    static int phiOptimize(int n){
        int res = n;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                res = res/i;
                res = res * (i-1);
                while(n%i==0){
                    n = n/i;
                }
            }
        }
        if(n>1){
            res = res/n;
            res = res * (n-1);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(phi(n));
        System.out.println("ETF("+n+") = "+phiOptimize(n));
    }
}