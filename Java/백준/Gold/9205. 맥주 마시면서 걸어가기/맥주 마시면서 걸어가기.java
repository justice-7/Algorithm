import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * @author justice_va
 * @date 24.03.28
 * @link https://www.acmicpc.net/problem/9205
 * @keyword_solution bfs
 * 맥주 한 박스 20개
 * 50미터에 한병씩 마심
 * 집 -> 편의점 -> 락 페스티벌
 * 두 좌표 사이의 거리: x좌표 + y좌표
 * @input 
 * 테스트 개수: t<=50
 * 편의점 개수: 0<= n <=100
 * 좌표: -32768 <= x,y <= 32767
 * @output 페스티벌에 갈 수 있으면 "happy", 없으면 "sad"
 * @time_complex 
 * @perf 
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int t,n,a,b;
	static Node[] point;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			point = new Node[n+2];
			for (int j=0; j<n+2; j++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				point[j] = new Node(a, b);
			}
			bfs();
		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		visit = new boolean[n+1];
		visit[0] = true;
		q.add(point[0]);
		while(!q.isEmpty()) {
			Node now = q.poll();
			if (Math.abs(point[n+1].x-now.x)+Math.abs(point[n+1].y-now.y) <= 1000) {
				sb.append("happy\n");
				return;
			}
			for (int i=1; i<n+1; i++) {
				if (!visit[i] && Math.abs(point[i].x-now.x)+Math.abs(point[i].y-now.y) <= 1000) {
					visit[i] = true;
					q.add(point[i]);
				}
			}
		}
		sb.append("sad\n");
	}

	public static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}