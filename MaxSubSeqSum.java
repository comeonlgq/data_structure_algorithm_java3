package niukewang;
/**
 * 最大连续子序列和的最大值
 * @author Administrator
 *
 */
import java.util.Scanner;
public class MaxSubSeqSum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int []a=new int[n];

		a[0]=sc.nextInt();
		int sum=a[0];
		int temp=a[0];
		
		for(int i=1;i<n;i++) {
			a[i]=sc.nextInt();
			if(temp<0) {
				temp=a[i];
			}else {
				temp+=a[i];
			}
			if(sum<temp) {
				sum=temp;
			}
		}
		sc.close();
		
//		for(int i=0;i<n;i++) {
//			temp+=a[i];
//			if(temp<0) {
//				temp=0;
//			}
//			if(sum<temp) {
//				sum=temp;
//			}
//		}
//		if(sum==0) {//当输入的全部是负数时候
//			sum=a[0];
//			for(int i=1;i<n;i++) {
//				if(sum<a[i]) {
//					sum=a[i];
//				}
//			}
//		}
		System.out.println(sum);
	}

}
