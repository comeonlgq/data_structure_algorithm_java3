package niukewang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，
 * 假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。 n个任务可以按照任意顺序放入CPU进行处理，
 * 现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 * 
 * @author Administrator
 * 0 1背包问题：  动态规划
 */
public class MinCPURunnTime {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
			sum += a[i];
		}

		Arrays.sort(a);
		
		int [][]dp=new int[n+1][sum/2+1]; //将问题转化为0-1背包问题
		
		for(int i=0;i<sum/2+1;i++) {
			dp[0][i]=0;//表示一个都不取
		}
		for(int i=1;i<=n;i++) {
			dp[i][0]=0;//表示虽然遍历了n个，但是一个也没选取
		}
		for(int i=1;i<=n;i++)
			for(int j=1;j<=sum/2;j++) {
				if(a[i-1]<=j) {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-a[i-1]]+a[i-1]);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		int res=Math.max(dp[n][sum/2], sum-dp[n][sum/2]);
		System.out.println(res);

	}

}
