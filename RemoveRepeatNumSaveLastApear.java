package niukewang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素， 但是小易想是对于每种元素保留最后出现的那个 小易遇到了困难,希望你来帮助他。
 * 
 * @author Administrator
 *
 */
public class RemoveRepeatNumSaveLastApear {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		List<Integer> s = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		for (int i = n - 1; i >= 0; i--) {
			if(!s.contains(a[i])) {
				s.add(a[i]);
			}
		}
			
		for(int i=s.size()-1;i>=0;i--) {
			System.out.print(s.get(i));
	         if(i>0)
	            System.out.print(" ");
		}
		System.out.println();

	}

}
