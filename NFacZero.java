package niukewang;
/**
 * 这是求阶层末尾有几个零的问题
 * @author Administrator
 *
 */
import java.util.Scanner;
public class NFacZero {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int count=n/5;
		while(n>=25) {
			n=n/5;
			count++;
		}
		System.out.println(count);
		
	}

}
