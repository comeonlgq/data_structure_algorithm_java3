package niukewang;

import java.util.Scanner;
import java.util.Vector;

/**
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。
 * 例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。
 * 牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
如样例所示: s = "aaabbaaac"
所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25
 * @author Administrator
 *
 */
public class AverageChipLen2 {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		String string=new String();
//		string=scanner.next();
		string="dccbbbbebeacdbbbbdbaaaabbeeeeaaddeeeeaabbbeeecdccc";
		
		StringBuilder sbBuilder =new StringBuilder();//用于保存不重复的
		sbBuilder.append(string.charAt(0));
		for(int i=1;i<string.length();i++) {
			if(string.charAt(i-1)!=string.charAt(i)) {
				sbBuilder.append(string.charAt(i));
			}
		}
		float c=string.length();
		c=c/sbBuilder.length();
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  
		System.out.println(df.format(c));
		scanner.close();
	}

}

