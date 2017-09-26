package niukewang;

import java.util.Scanner;

/**
 * 在幼儿园有n个小朋友排列为一个队伍，从左到右一个挨着一个编号为(0~n-1)。
 * 其中有一些是男生，有一些是女生，男生用'B'表示，女生用'G'表示。
 * 小朋友们都很顽皮，当一个男生挨着的是女生的时候就会发生矛盾。
 * 作为幼儿园的老师，你需要让男生挨着女生或者女生挨着男生的情况最少。
 * 你只能在原队形上进行调整，每次调整只能让相邻的两个小朋友交换位置，
 * 现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。例如：
GGBBG -> GGBGB -> GGGBB
这样就使之前的两处男女相邻变为一处相邻，需要调整队形2次 
 * @author Administrator
 *
 */
public class BoyGirlNotNear {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		String s=new String();
		s=sc.next();
		
		int i=0,j=s.length()-1;
		int len1=0;
		int len2=0;
		while(i<j) {
			while(i<j && s.charAt(i)==s.charAt(i+1))
				i++;
			len1=i+1;
			while (i<j && s.charAt(j)==s.charAt(j-1)) {
				j--;
			}
			len2=s.length()-j;
		}
		int count=0;
		char a;
		if(len1>len2) {//向左移动
			a=s.charAt(0);
			int pre=i+1;
			for(int k=pre;k<s.length();) {
				int times=0;
				while(s.charAt(k)!=a) {
					k++;
					times++;
				}
				count+=times;
				pre=times;
			}
			
		}else {//向右移动
			a=s.charAt(s.length()-1);
			
			
		}
		
		
		sc.close();
	}

}
