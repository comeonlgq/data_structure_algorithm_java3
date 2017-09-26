package niukewang;
/**
 * 十进制转化为M进制的代码
 * @author Administrator
 *
 */
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import javax.xml.stream.events.StartDocument;
public class TenConvertToMSystem {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int n=sc.nextInt();
			int m=sc.nextInt();
			Vector<Integer> v =new Vector<Integer>();
			int t=n;
			while(t>0) {
				v.add(t%m);
				t=t/m;
			}
			for(int i=v.size()-1;i>=0;i--) {
				if(v.get(i)>9) {
					char c=(char) (v.get(i)-10+'A');
					System.out.print(c);
				}else {
					System.out.print(v.get(i));
				}
			
			}
	
		
			System.out.println();
		}
	}

}
