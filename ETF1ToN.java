//Find efficient way to find phi(n) from 1 to n where n<=10^6
//using seive we can do this
//

import java.util.*;
class ETF1ToN
{
    static int phi[] = new int[1000001];
    static int maxN = 1000000;
    static void init(){
        for(int i=1;i<=maxN;i++){
            phi[i] = i;
        }
        for(int i=2;i<=maxN;i++){
            if(phi[i]==i){
                for(int j=i;j<=maxN;j=j+i){
                    phi[j] = phi[j] /i;
                    phi[j] = phi[j] * (i-1);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        init();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            System.out.println(phi[n]);
        }
    }
}