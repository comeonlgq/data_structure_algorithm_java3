package niukewang;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 * @author Administrator
 *
 */

public class FindNumSumEqualToArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int sum=sc.nextInt();
		int []a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		sc.close();
		Arrays.sort(a);
		int count=0;
		count = getNums(a,sum,0,n-1,count);
		System.out.println(count);
	}
	
	//使用递归发现超过时间了
	public static int getNums(int []a,int sum,int start,int end,int count) {
		
		if(end<start) {
			return count;
		}

		if(a[end]==sum) {
			count++;
			getNums(a,sum,start,end-1,count);
		}
		if(a[end]>sum) {
			getNums(a,sum,start,end-1,count);
		}
		if(a[end]<sum) {
			getNums(a, sum-a[end], start, end-1, count);
		}
		
		return count;
			
	}
	
	//使用动态规划 dp[i][sum],其中i表示第几个点，sum表示的是前几个数之和，dp[i][sum]表示值等于sum的个数
	public static int getNum(int n,int sum,int []a) {
		int [][]dp=new int[n+1][sum+1]; 
		
		//初始化dp，用前i个组成和为0的方案只有一种，就是什么也不取
		for(int i=0;i<=n;i++) {
			dp[i][0]=1;
		}
		//用0个元素不能组成1~sum
		for(int i=0;i<sum;i++) {
			dp[0][i]=0;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=sum;j++) {
				if(a[i]<=j) dp[i][j]=dp[i-1][j]+dp[i-1][j-a[i]];
				else
				   dp[i][j]=dp[i-1][j];
			}
		}
		
		return dp[n][sum];
	}
	

}
