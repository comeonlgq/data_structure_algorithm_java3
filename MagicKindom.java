package niukewang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

/**
 * 魔法王国一共有n个城市,编号为0~n-1号,n个城市之间的道路连接起来恰好构成一棵树。
 * 小易现在在0号城市,每次行动小易会从当前所在的城市走到与其相邻的一个城市,小易最多能行动L次。
 * 如果小易到达过某个城市就视为小易游历过这个城市了,小易现在要制定好的旅游计划使他能游历最多的城市,
 * 请你帮他计算一下他最多能游历过多少个城市(注意0号城市已经游历了,游历过的城市不重复计算)。
 * 
 * @author Administrator
 *
 */
public class MagicKindom {

	static int x = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int L = in.nextInt();
		Vector<Integer> v=new Vector<Integer>(n);//用于存放到达某个城市已经游玩的城市数量
		v.add(0, 1);//表示0号城市已经游玩过了
		int res=1;//初始值为1，是因为0号城市已经游玩过了
		for (int i = 1; i < n; i++)
		{
			int parent = in.nextInt();//i城市的上一个城市parent
			
			v.add(i, v.get(parent)+1);//表示到达i城市已经游玩的城市数量
			if(v.get(i)>res) {//更新游玩城市的数量
				res=v.get(i);
			}
			
		}
		
		if(res<L+1) {//如果已经逛完最长路线上的所有城市
			int res_temp=res+(L-res+1);
			if(res_temp>n) {
				System.out.println(n);
			}else {
				System.out.println(res+(L-res+1)/2);
			}
			
		}else {//没有逛完最长的路线上所有的城市
			System.out.println(L+1);
		}
	}
}
