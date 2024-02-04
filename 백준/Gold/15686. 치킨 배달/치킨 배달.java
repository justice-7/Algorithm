import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m, result=Integer.MAX_VALUE;
	static int[] visit;
	static ArrayList<Point> house, chicken;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		house = new ArrayList<>(); // 집 좌표 저장
		chicken = new ArrayList<>(); // 치킨집 좌표 저장

		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				int n = Integer.parseInt(st.nextToken()); 
				if (n==1)
					house.add(new Point(i, j));
				else if (n==2)
					chicken.add(new Point(i, j));
			}
		}
		visit = new int [chicken.size()];
		sol(0,0);
		System.out.println(result);
	}

	public static void sol(int cnt, int start) {
		if (cnt == m) {
			int total = 0;
			for (int j=0; j<house.size(); j++) {
				int min = Integer.MAX_VALUE;
				for (int k=0; k<chicken.size(); k++) {
					if (visit[k]==1) {
						int dis = Math.abs(house.get(j).x-chicken.get(k).x) 
								+ Math.abs(house.get(j).y-chicken.get(k).y);
						min = Math.min(min, dis);
					}
				}
				total += min;
			}
			result = Math.min(result, total);
			return;
		}
		for (int i=start; i<chicken.size(); i++) {
			if (visit[i]==0) {
				visit[i]=1;
				sol(cnt+1, i+1);
				visit[i]=0;
			}
		}
	}
}

class Point {
	int x;
	int y;
	Point (int x, int y){
		this.x = x;
		this.y = y;
	}
}