package niukewang;

import java.awt.Point;
import java.util.Scanner;

/**
 * 终于到周末啦！小易走在市区的街道上准备找朋友聚会，突然服务器发来警报,
 * 小易需要立即回公司修复这个紧急bug。假设市区是一个无限大的区域，
 * 每条街道假设坐标是(X，Y)，小易当前在(0，0)街道，办公室在(gx,gy)街道上。
 * 小易周围有多个出租车打车点，小易赶去办公室有两种选择，一种就是走路去公司，
 * 另外一种就是走到一个出租车打车点，然后从打车点的位置坐出租车去公司。
 * 每次移动到相邻的街道(横向或者纵向)走路将会花费walkTime时间，
 * 打车将花费taxiTime时间。小易需要尽快赶到公司去，现在小易想知道他最快需要花费多少时间去公司。 

 * @author Administrator
 *
 */
public class MinRoute {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		Point taxi[]=new Point[n];
		for(int i=0;i<n;i++) {
			taxi[i]=new Point();
			taxi[i].x=scanner.nextInt();
		}
		for(int i=0;i<n;i++)
			taxi[i].y=scanner.nextInt();
		Point company=new Point();
		company.x=scanner.nextInt();
		company.y=scanner.nextInt();
		int walkTime=scanner.nextInt();
		int taxiTime=scanner.nextInt();
		
		int costWalk=(Math.abs(company.x)+Math.abs(company.y))*walkTime;
		
		//采用蛮力法
		int []costTaxi=new int[n];
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			costTaxi[i]=(Math.abs(company.x-taxi[i].x)+Math.abs(company.y-taxi[i].y))*taxiTime+walkTime*(Math.abs(taxi[i].x)+Math.abs(taxi[i].y));
			if(costTaxi[i]<min) {
				min=costTaxi[i];
			}
		}
		System.out.println(min<costWalk ? min : costWalk);
		
		
//		int costTaxi=0;
//		Point near=new Point();
//		near.x=taxi[0].x;
//		near.y=taxi[0].y;
//		for(int i=1;i<n;i++) {
//			if(Math.abs(taxi[i].x)+Math.abs(taxi[i].y) < Math.abs(near.x)+Math.abs(near.y)) {
//				near.x=taxi[i].x;
//				near.y=taxi[i].y;
//			}
//		}
//		costTaxi=(Math.abs(company.x-near.x)+Math.abs(company.y-near.y))*taxiTime+walkTime*(Math.abs(near.x)+Math.abs(near.y));
//	    System.out.println(costTaxi<costWalk ? costTaxi : costWalk);
	}

}
