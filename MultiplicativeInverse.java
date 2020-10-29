//in devision modulo is not working ..using this we can do it
//10/5 = 10 * (1/5) => 10 * (0.2)
//we can replace devision operatior with multiplication and on multiplication we can do modulo airthmetic
//(a/b)%p = (a*x)%p where x modulo multplicative inverse of 1/b => (a%p * x%p)%p
//mmi of 5 under 7 is 3 => 15%7=1
//(6/2)%5 =first find mmi of 2 under 5 means (2*k)%5 =1 =>for that we have to put 1 to 4 in k => k = 3 is answer because (2*3)%5=6%5=1
//so we mmi = 3 => (6*3)%5 = 18%5 = 3 so we can get the same answer
//do all numberss have mmi? - no ...12 under modulo 6 not found..means coPrime(a,b)=1 then exist of modulo multiplicative inverse

//fermat's little theorem
//where is m prime no
//a^(m-1) = 1 mod m..devide by m both side
//a^(m-2) = a^-1 mod m..means to find a-1 simply do a ^ m-2

import java.util.*;
class MultiplicativeInverse{
    public static int power(int a,int b,int m){
        int result = 1;
        while(b>0){
            if(b%2==1){
                result = (result * a)%m;
            }
            a = (a * a)%m;
            b = b/2;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int m = sc.nextInt();
            System.out.println("a^-1:"+power(a,m-2,m));
        }
    }
}
 