//find nth term of fibonacci using matrix expontiation->takes logn time

//[f1 f2] * megic matrix = [f2 f3]
//[f1 f2] * (magic matrix)^2 = [f3 f4]
//so kth term = (magic matrix ^ k-1) * [f1 f2] => answer matrix's first term is answer

//complexity-magic matrix is 2*2=>m^3 logn = 8logn 

//how to find magic marix 
//suppose magic matrix's term is a b c d
//apply multiplication=> 
//f1*a + f2*c = f2...equation 1
//f1*b + b2*d = f3...equation 2
//so a=0 c=1
//b=1 d=1

//magic matrix also called transaction matrix
import java.util.*;
class NthFibonacci{
    static long arr[] = new long[3];
    static long identity[][] = new long[3][3];
    static long magic[][] = new long[3][3];

    static long getFib(int n){
        if(n<=2)    return arr[n];//first and second term also given so not process anything
        identity[1][1]=identity[2][2]=1;
        magic[1][1]=0;
        magic[1][2] = magic[2][1] = magic[2][2] = 1;
        n = n-1;
        while(n>0){
            if(n%2==1){
                multiply(identity,magic,2);
                n--;
            }
            else{
                multiply(magic,magic,2);
                n = n/2;
            }
           
        }
        long ans = arr[1]*identity[1][1] + arr[2] * identity[2][1];

        return ans;
    }

    static void multiply(long identity[][],long magic[][],int dim){
        long res[][] = new long[dim+1][dim+1];
        for(int i=1;i<=dim;i++){
            for(int j=1;j<=dim;j++){
                res[i][j]=0;
                for(int k=1;k<=dim;k++){
                    res[i][j] += identity[i][k] * magic[k][j];
                }
            }
        }
        for(int i=1;i<=dim;i++){
            for(int j=1;j<=dim;j++){
                identity[i][j] = res[i][j];
            }
        }
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       while(t-->0){
            
            arr[1] = sc.nextLong();//first term
            arr[2] = sc.nextLong();//second term
            int n = sc.nextInt();
            System.out.println(getFib(n));
        }
    }
}