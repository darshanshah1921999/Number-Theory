//it is use to find a^n in logn time

import java.util.*;
class BinaryExponentiation{
    static int power(int a,int b){
        int ans = 1;
        while(b>0){
            if(b%2==1){
                ans = ans * a;
            }
            b = b/2;
            a = a * a;
        }
        return ans;
    }
    static int powerModK(int a,int b,int k){
        int ans = 1;
        while(b>0){
            if(b%2==1){
                ans = (ans*a)%k;
            }
            a = (a*a)%k;
            b = b/2;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(power(a,b));
    }
}