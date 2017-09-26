package niukewang;

import java.util.Scanner;

/**
 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
牛博士给小易出了一个难题:
对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 * @author Administrator
 *
 */
public class NearMultiFour {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int []A=new int[n];
		for(int i=0;i<n;i++) {
			A[i]=scanner.nextInt();
		}
		
		int []num=new int[3];
		for(int i=0;i<n;i++) {
			if(A[i]%4==0) {
				num[2]++;
			}else {
				if(A[i]%2==0)
					num[1]++;
				else {
					num[0]++;
				}
			}
		}
		if(num[2]==n) System.out.println("Yes");
		if(num[1]==n) System.out.println("Yes");
		if(num[1]+num[2]==n) System.out.println("Yes");
		if(num[0]+num[1]==n) System.out.println("No");
		if(num[0]+num[2]==n) {
			if(num[0]<=num[2])
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		if(num[0]!=0 && num[1]!=0 && num[2]!=0) {
			if(num[0]<=num[2]) {
				System.out.println("Yes");
			}else
				System.out.println("No");
		}

		
	}

}
