package niukewang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 堆砖块
 * 小易有n块砖块，每一块砖块有一个高度。小易希望利用这些砖块堆砌两座相同高度的塔。
 * 为了让问题简单，砖块堆砌就是简单的高度相加，
 * 某一块砖只能使用在一座塔中一次。小易现在让能够堆砌出来的两座塔的高度尽量高，小易能否完成呢。 
 * @author Administrator
 *
 */
public class BlockCreate {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int []height=new int[n];
		for(int i=0;i<n;i++) {
			height[i]=scanner.nextInt();
		}
		Arrays.sort(height);
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=height[i];
		}
		int j=n-1;
		while(j>=0 && height[j]>sum/2) {
			j--;
		}
		if(j<1) {
			System.out.println("-1");
			return;
		}
		
		Number []numbers=new Number[j+1];
		for(int i=0;i<=j;i++) {
			numbers[i].value=height[i];
			numbers[i].sum=height[i];
			numbers[i].aList.add(height[i]);
		}
		
		for(int s=sum/2;s>0;s--) {//s表示的是两个塔的高度，问题转换为在数组中找两组和值等于s的数组队
			findNSum(numbers,s-numbers[j].value,0,j);
		}
		
	}
	
	public static void findNSum(Number []numbers,int s,int left,int right) {
		int j=right;
		while(j>=left && numbers[j].value>s) {
			j--;
		}
		if(j<1) {
			System.out.println("-1");
			return;
		}else {
			
			for(int i=left;i<=j;i++) {
				if(numbers[i].value == s) {
					
				}else {
					findNSum(numbers, s-numbers[j].value,left, right-1);
				}
			}
		
		}
	}

	
	static class Number{
		int value;//存放值
		List<Integer> aList=new ArrayList<Integer>();//存放与该值相加和为某个值得组合
		int sum;//存放该数可以组成的和值
		
	}
	

}
