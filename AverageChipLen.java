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
public class AverageChipLen {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		String string=new String();
		string=scanner.next();
//		string="dccbbbbebeacdbbbbdbaaaabbeeeeaaddeeeeaabbbeeecdccc";
		Vector<CharacterNew> vc=new Vector<CharacterNew>();
		for(int i=0;i<string.length()-1;) {
			int t=1;
			while((i+t)<string.length() && string.charAt(i+t-1)==string.charAt(i+t)) {
				t++;
			}
			vc.add(new CharacterNew(string.substring(i,i+t)));
			i=i+t;
		}
		
		if(string.charAt(string.length()-1)!=string.charAt(string.length()-2)) {
			vc.add(new CharacterNew(string.substring(string.length()-1,string.length())));
		}
		float c=0;
		for(int i=0;i<vc.size();i++) {
			System.out.println(vc.get(i).string);
			c+=vc.get(i).size;
		}
		System.out.println(c+"  "+vc.size());
		c=c/vc.size();
		java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  
		System.out.println(df.format(c));
		scanner.close();
	}

}
class CharacterNew{
	String string;
	int size;
	
	public CharacterNew(String s) {
		string =new String();
		string =s;
		size=string.length();
	}
}
