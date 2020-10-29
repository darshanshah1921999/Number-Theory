//need->when queries are given to 10^6 and all number check prime number or not at that time seive is used 
//approach->we can generate all prime numbers up to number n and solve each query in o(1)
//complexity-o(Nlog(logN))
//space - o(N)
//query time - o(1)

import java.util.*;

class Seive{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int vis[] = new int[n+1];
        vis[0] = 1;
        vis[1] = 1;
        for(int i=2;i*i<=n;i++){
            if(vis[i]==0){
                for(int j=i*i;j<=n;j=j+i){
                    vis[j]=1;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(vis[i]==0){
                System.out.print(i+" ");
            }
        }
    }
}