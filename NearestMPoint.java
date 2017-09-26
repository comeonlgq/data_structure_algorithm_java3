package niukewang;

import java.util.Scanner;

/**
 * 题目要求查找最近的m个点
 * @author Administrator
 *
 */
public class NearestMPoint {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();//空间中点的个数
		int k=scanner.nextInt();//点的维度
		
		Points []points =new Points[n];//用于存放点的位置
		
		for(int i=0;i<n;i++) {
			int []a=new int[k];//该语句必须要放在这个地方，如果放在for的外面，执行points[i]=new Points(a, k, i);只是存储了最后一次a的值
			for(int j=0;j<k;j++) {
				a[j]=scanner.nextInt();
			}
			points[i]=new Points(a, k);
		}
//	    for(int i=0;i<n;i++)
//	    	System.out.println(Arrays.toString(points[i].location));
		int t=scanner.nextInt();//查询的次数
		for(int i=0;i<t;i++) {
			int []p=new int[k];//需要查询点的坐标
			for(int j=0;j<k;j++) {
				p[j]=scanner.nextInt();
			}
			int m=scanner.nextInt();//需要查询的最近顶点的个数
			
			//采用优先队列的方法,方法二：使用优先队列
	//		PriorityQueue<Points> points2= new PriorityQueue<Points>();
			
			double []dis=new double[n];
			for(int j=0;j<n;j++) {//计算要查询的点到空间各个点之间的距离
//				System.out.print(Arrays.toString(points[j].location));
				points[j].dis=euclidean(p,points[j].location);
	//			points2.add(points[j]);
//				System.out.println(points[j].dis);
			}
			
//	    	System.out.println("the closet "+m+" points are:");
//	    	for(int ii=0;ii<m;ii++) {
//	    		System.out.print(Arrays.toString(points2.poll().location));
////	    		for(int jj=0;jj<k;jj++) {
////	    			System.out.print(points2.poll());
////	    			if(jj<k-1) {
////	    				System.out.print(" ");
////	    			}
////	    		}
//	    		System.out.println();
//	    	}
			
			//查找最近的m个顶点，方法一：使用快速排序
			findMinM(m,points,k);
		}
		scanner.close();
		
	}
	
	//计算两点之间的欧几里得距离
	public static double euclidean(int []p1,int []p2) {
		double d=0;
		
		for(int i=0;i<p1.length;i++) {
			d+=Math.pow((p1[i]-p2[i]), 2);
		}
		
		return Math.sqrt(d);
	}
	
	//快速排序的方法查找最小的 m 个值
    public static void findMinM(int m,Points []p,int k) {
    	
    	//首先对距离进行洗牌
    	for(int i=0;i<p.length;i++) {
    		int t=(int)Math.random()*(i-1);
    		swap(p, i, t);
    	}

    	for(int i=0;i<m+1;i++) {
    		quicksort(p,0,p.length-1,i);
    	}
    	
    	//检查m个与m+1个距离是否一样
    	if(p[m-1].dis==p[m].dis) {
    		System.out.println("not exist!");
    		return;
    	}
    	
    	System.out.println("the closet "+m+" points are:");
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<k;j++) {
    			System.out.print(p[i].location[j]);
    			if(j<k-1) {
    				System.out.print(" ");
    			}
    		}
    		System.out.println();
//    		System.out.println(Arrays.toString(p[i].location));
    	}
    }
    
    public static void swap(Points []p,int i,int j) {
    	Points tPoints=p[i];
    	p[i]=p[j];
    	p[j]=tPoints;
    }
	
    public static void quicksort(Points []p,int left,int right,int m) {
    	Points t=p[m];
    	double pivot=t.dis;
    	int i=m,j=right;
    	while(i<j) {
    		
    		while(j>i && p[j].dis>=pivot) j--;
    		if(i<j)
    		   p[i++]=p[j];
    		
    		while(i<j && p[i].dis<=pivot) i++;
    		if(i<j) {
    			p[j--]=p[i];
    		}
    	
    	}
    	p[i]=t;
    	if(i==m) {
    		return;
    	}
    	if(i>m) {
    		if(i-1>left) 
    		quicksort(p,left,i-1,m);
    	}
    	if(i<m) {
    		if(i+1<right) 
        		quicksort(p,i+1,right,m);
    	}
    	
    }
}

class Points implements Comparable<Points>{
	int []location;//点的位置
	double dis;//点到查询点的距离
	
	public Points(int i,int []loc,double d,int k) {
		location=new int[k];
		location=loc;
		dis=d;
	}
	
	public Points(int []loc,int k) {
		location=new int[k];
		location=loc;
		dis=0;
	}

	@Override
	public int compareTo(Points o) {//升序
		if(o.dis<this.dis)
			return 1;
		if(o.dis>this.dis)
			return -1;
		return 0;
	}
	
}
