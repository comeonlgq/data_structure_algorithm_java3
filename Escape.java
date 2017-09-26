package niukewang;

import java.util.LinkedList;
import java.util.Scanner;

public class Escape {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int p = sc.nextInt();
        
		int[][] o = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				o[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		LinkedList<Cordinate> route=new LinkedList<Cordinate>();
		route.add(new Cordinate(0, 0));
		int cost=p;
		int i=0;int j=0;
		while(cost>=0 && j<m) {
			if(o[i][j+1]==0) {
				i=i+1;
				cost=cost-1;
				route.add(new Cordinate(i, j));
			}else {
				j=j+1;
				cost=cost-3;
				route.add(new Cordinate(i, j));
			}
		}
		
		if(j>=m-1) {
			for(i=0;i<route.size();i++) {
				System.out.print("["+route.get(i).x+","+route.get(i).y+"]");
				if(i<route.size()-1) {
				   System.out.print(",");
				}
			}
		}else {
			System.out.println("Can not escape!");
		}
		
	}

}

class Cordinate{
	int x;
	int y;
	
	public Cordinate(int x,int y) {
		this.x=x;
		this.y=y;
	}

}
