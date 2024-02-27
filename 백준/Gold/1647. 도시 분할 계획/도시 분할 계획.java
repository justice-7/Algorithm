import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author justice_va
 * @date 24.02.26
 * @link https://www.acmicpc.net/problem/1647
 * @keyword_solution MST
 * 마을을 두개로 분리
 * 길의 유지비 합 최소
 * 1. MST의 모든 간선 가중치 합 구함
 * 2. 가장 가중치 높은 간선 찾아서 없앰
 * @input 
 * 집의 개수: 2<= n <=100,000
 * 길의 개수: 1<= m <=1,000,000
 * 길의 유지비: 1<= c <=1,000
 * @output 없애고 남은 길의 유지비의 합의 최솟값
 * @time_complex 
 * @perf 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static List<Node>[] g;
	static int[] visit;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		g = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			g[i] = new ArrayList<>();
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g[a].add(new Node(b,c));
			g[b].add(new Node(a,c));
		}
		visit = new int[n+1];
		System.out.println(prim());
	}

	public static int prim() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));
		int total = 0;
		int maxW = 0;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (visit[now.v]==0) {
				visit[now.v] = 1;
				total += now.w;
				maxW = Math.max(maxW, now.w);
			}
			else
				continue;
			for (int i=0; i<g[now.v].size(); i++) {
				Node next = g[now.v].get(i);
				if (visit[next.v] == 0)
					pq.offer(next);
			}
		}
		return total-maxW;
	}

	public static class Node implements Comparable<Node>{
		int v;
		int w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}		
	}
}