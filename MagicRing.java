package niukewang;

import java.util.Scanner;

/**
 * 小易拥有一个拥有魔力的手环上面有n个数字(构成一个环),
 * 当这个魔力手环每次使用魔力的时候就会发生一种奇特的变化：
 * 每个数字会变成自己跟后面一个数字的和(最后一个数字的后面一个数字是第一个),
 * 一旦某个位置的数字大于等于100就马上对100取模(比如某个位置变为103,就会自动变为3).
 * 现在给出这个魔力手环的构成，请你计算出使用k次魔力之后魔力手环的状态。 
 * @author Administrator
 *
 */
public class MagicRing {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int k=scanner.nextInt();
		int []a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=scanner.nextInt();
		}
		
		int []t=new int[k];
		for(int i=0;i<k;i++) {
			t[i]=a[i];
		}
		for(int i=0;i<n-1;i++) {
			int temp=0;
			for(int j=1;j<k;j++) {
				if(i+j>=n) {
					temp+=t[(i+j)%n];
				}else {
					temp+=a[i+j];	
				}
			}
			temp*=k;
			if(i+k>=n) {
				a[i]=a[i]+temp+t[(i+k)%n];
			}else {
				a[i]=a[i]+temp+a[i+k];
			}
			if(a[i]>=100)
				a[i]=a[i]%100;
		}
		int temp1=0;
		for(int j=0;j<k-1;j++) {
			temp1+=t[j];
		}
		temp1*=k;
		a[n-1]=a[n-1]+temp1+t[k-1];
		if(a[n-1]>=100)
			a[n-1]=a[n-1]%100;
		
		for(int i=0;i<n;i++) {
			System.out.print(a[i]);
			if(i<n-1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

}
