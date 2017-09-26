package niukewang;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 分饼干的代码
 * @author Administrator
 *
 */
public class DivideBiscuits {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		
		String string=new String();
		string=scanner.next();
		BigInteger n=scanner.nextBigInteger();

		String s1=new String();
		String s2=new String();
	    for(int i=0;i<string.length();i++) {
		   if(string.charAt(i)=='X') {
			   s1=s1+'0';
			   s2=s2+'9';
			}else {
				s1=s1+string.charAt(i);
				s2=s2+string.charAt(i);
			}
	   }
	    BigInteger a= new BigInteger(s1);
	    BigInteger b= new BigInteger(s2);
	    
	    int count=0;
	    if(a.mod(n).equals(0) || b.mod(n).equals(0)) {
	    	count++;
	    }
	    
		a=a.divide(n);
		b=b.divide(n);
	
		count+=(b.intValue()-a.intValue());

		System.out.println(count);
	}

}
