//check a number is prime or not 
//15 factors -> 1,3,5,15..we can pair this ->(1,15),(3,5) 
//here observation is we can get second devisor by dividing number so loop till 3..means loop till sqrt(n)

//complexity-sqrt(N)
import java.util.*;

class PrimalityTest{
    public static boolean checkPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return  true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            if(checkPrime(n)){
                // System.out.println(n+" is Prime");
                System.out.println("yes");
            }
            else{
                // System.out.println(n+" is not Prime");
                System.out.println("no");
            }
        }   
    }
}
