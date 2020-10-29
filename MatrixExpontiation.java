//given a matrix n and power n--> find a^n
//complexity of brute force a is 3*3 so ..o(m^3*n)
// same logic as binaryExponentiation for optimization

import java.util.*;
class MatrixExpontiation{
    static int arr[][];
    static int identity[][];

    //power function do arr^n
    public static void power(int dim,int n){
        identity = new int[dim][dim];
        //create identity matrix
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                if(i==j)    identity[i][j]=1;
                else    identity[i][j]=0;
            }
        }
        for(int i=0;i<n;i++){
           //identity = identity * arr;
            multiply(arr,identity,dim);
        }

        //identity contains ans but we want ans in arr so copy element in arr
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                arr[i][j] = identity[i][j];
            }
        }
    }

    public static void powerOptimize(int dim,int n){
        identity = new int[dim][dim];
        //create identity matrix
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                if(i==j)    identity[i][j]=1;
                else    identity[i][j]=0;
            }
        }
        while(n>0){
            if(n%2==1){
                multiply(arr,identity,dim);
            }
    
            n = n/2;
            multiply(arr,arr,dim);
        }
    }

    //do multiply two matrix 
    public static void multiply(int[][] arr,int[][] identity,int dim){
        int res[][] = new int[dim][dim];
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                res[i][j] = 0;
                for(int k=0;k<dim;k++){
                    res[i][j] += arr[i][k] * identity[k][j];
                }
            }
        }

        //res contans answer but we want answer in Identity metrix => identity = identity * arr
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                identity[i][j] = res[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dim = sc.nextInt();
        int n = sc.nextInt();
        arr = new int[dim][dim];
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        powerOptimize(dim,n);
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}