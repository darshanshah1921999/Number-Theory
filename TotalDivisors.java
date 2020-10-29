//find totoal number of divisors from prme factorization of a number N
//Given a number's prime factorization ,find total number of diisor and print
// it modulo 10^9+7

// example
// 3
// 2 1000
// 3 1500
// 13 10000000

//2^1000 + 3^1500+13^1000000..find the number of divisor 

//n = p1^y1 + p2 ^ y2 +..pn^yn
//p1,p2..pn is prime no
//factor is - (y1+1)*(y2+1)*...(yn+1)

//n=300
//n = 2^2 * 3^1 * 5^2
//total divisor = (2+1)*(1+1)*(2+1) = (3*2*3) = 18

//why this works

//  For above example using propabblity 3 box 1st for 2 second for 3 and third for 5 
//  each box have power + 1 posiblity ...not take or 1 take or 2 take...



import java.util.*;
class TotalDivisors{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 1;
        int mod = 1000000007;
        while(n-->0){
            int primeNo = sc.nextInt();
            int power = sc.nextInt();
            ans = ans * (power+1);
            ans = ans%mod;
        }
        System.out.println(ans);
    }
}