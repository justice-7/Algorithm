import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author justice_va
 * @link https://www.acmicpc.net/problem/4386
 * @keyword_solution mst
 * 간선 가중치: 두 별 사이의 거리
 * 1. 각 간선의 가중치 구하기 - O(n²)
 * 2. mst(프림) - O(n²logn)
 * @input 
 * 별의 개수: 1<= n <=100
 * 좌표: 1000이하 양의 실수
 * @output 별자리를 만드는 최소 비용
 * @time_complex O(n²logn)
 * @perf 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static double[][] star;
	static List<Node>[] g;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		star = new double[n][2];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}
		g = new ArrayList[n];
		for (int i=0; i<n; i++) {
			g[i] = new ArrayList<>();
		}
		for (int j=0; j<n; j++) {
			for (int k=0; k<n; k++) {
				if (j!=k) {
					g[j].add(new Node(k,Math.sqrt(Math.pow(star[k][0]-star[j][0], 2)+Math.pow(star[k][1]-star[j][1], 2))));
				}
			}
		}
		visit = new boolean[n];
		System.out.println(prim());
	}
	public static double prim() {
		double result = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0,0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (!visit[now.num])
				visit[now.num]=true;
			else 
				continue;
			result += now.w;
			for (int i=0; i<g[now.num].size(); i++) {
				Node next = g[now.num].get(i);
				if (!visit[next.num])
					pq.offer(next);
			}
		}
		return result;
	}
	
	public static class Node implements Comparable<Node>{
		int num;
		double w;
		public Node(int num, double w) {
			this.num = num;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return (this.w-o.w)==0?0: (this.w-o.w)>0?1:-1;
		}
	}
}