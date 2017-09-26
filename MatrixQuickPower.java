package niukewang;

import java.util.Random;
import java.util.Scanner;

/**
 * 矩阵快速幂 算法代码 ：用于计算某个数的幂次，将O(N)的复杂度降低为log(N)
 * 
 * @author Administrator
 *
 */
public class MatrixQuickPower {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			int k= scanner.nextInt();
			
			//用一个二维数组存储
			int [][]arr=new int[1][n];
			for(int i=0;i<n;i++) {
				arr[0][i]=scanner.nextInt();
			}
			 //初始化单元矩阵
	        int[][] mul = new int[n][n];
	        for (int i = 0; i < n; i ++) {
	                if (i < n - 1) {
	                    mul[i][i] = 1;
	                    mul[i + 1][i] = 1;
	                } else {
	                    mul[i][i] = 1;
	                    mul[0][i] = 1;
	                }
	        }
	        
	        for (; k > 0; k >>= 1) {
	            if ((k & 1) == 1) {
	                arr = Core(arr, mul);
	            }
	            mul = Core(mul, mul);
	         }
	         int i;
	         for (i = 0; i < n - 1; i ++) {
	             System.out.print(arr[0][i] + " ");
	         }
	         System.out.println(arr[0][i]);
		
		}

	}
	
	private static int[][] Core(int[][] a, int[][] b) {
        int rowRes = a.length;
        int columnRes = b[0].length; //TODO:
        int columnA = a[0].length; // == b.length;
 
        int[][] c = new int[rowRes][columnRes];
        for (int i =0; i < rowRes; i ++) {
            for (int j = 0; j < columnRes; j ++) {
 
                for (int k = 0; k < columnA; k ++) {
                    if (a[i][k] == 0 || b[k][j] == 0) {
                        continue;          //剪枝
                    }
 
                    c[i][j] += a[i][k] * b[k][j];
                }
                //100取余运算
                if (c[i][j] >= 100) {
                    c[i][j] %= 100;
                }
            }
        }
        return c;
    }
 
	
	
	public static void matrixQuickPower(int a,int n) {
		
		
		
		
		
		
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				Matrix matrix =new Matrix();
				Random random = new Random();
				matrix.a[i][j]=random.nextInt()%10;
				System.out.print(matrix.a[i][j]+" ");
				
			}
			System.out.println();
		}
		System.out.println();
		Matrix res=new Matrix();
		res.a[0][0]=res.a[1][1]=res.a[2][2]=1;
		
		while(n>0) {
			
		}
		
		
	}

	
	static class Matrix{
		public int a[][]=new int[3][3];
		
		
	}
}
