package niukewang;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

/**
 * 魔法王国一共有n个城市,编号为0~n-1号,n个城市之间的道路连接起来恰好构成一棵树。
小易现在在0号城市,每次行动小易会从当前所在的城市走到与其相邻的一个城市,小易最多能行动L次。
如果小易到达过某个城市就视为小易游历过这个城市了,小易现在要制定好的旅游计划使他能游历最多的城市,
请你帮他计算一下他最多能游历过多少个城市(注意0号城市已经游历了,游历过的城市不重复计算)。 
 * @author Administrator
 *
 */
public class VisitNum {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int L=scanner.nextInt();
		int []parent=new int[n-1];
		for(int i=0;i<n-1;i++) {
			parent[i]=scanner.nextInt();
		}
		
		int []vistNum=new int[n-1];
		
		for(int i=0;i<n-1;i++) {
			Vector<Integer> vc = new Vector<Integer>();
			vc.add(i+1);
			for(int j=0;j<n-1;j++) {
				if(vc.contains(j+1) || vc.contains(parent[j])) {
					if(i+1==parent[j] && (j+1)!=parent[j])
						vc.add(parent[j]);
					vistNum[i]++;
				}
			}
//			if(!vc.contains(0)) {//对于与初始顶点0不相连的，将其vistNum赋值为0
//				vistNum[i]=0;
//			}
		}
		
		System.out.println(Arrays.toString(vistNum));
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>();
		for(int i=0;i<n-1;i++) {
			queue.add(vistNum[i]);
		}
		int count=0;
		for(int i=0;i<L;i++) {
			if(!queue.isEmpty()) {
			  queue.poll();
			  count++;
			}else {
				break;
			}
		}
		System.out.println(count);
		scanner.close();
	}

}

class Node{
	int index;//顶点索引
	Vector<Integer> near;//存放相邻的顶点编号
	int value;//表示从该顶点最多可以到达多少城市
	
	public Node() {
		near=new Vector<Integer>();
		value=0;
		index=0;
	}
	
	public void addNear(int a) {
		near.add(a);
	}
}
