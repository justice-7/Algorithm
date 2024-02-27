import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m,a,b,c;
	static List<Node>[] g;
	static int[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		g = new ArrayList[n+1];
		for (int i=1; i<=n; i++)
			g[i] = new ArrayList<>();
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			g[a].add(new Node(b,c));
			g[b].add(new Node(a,c));
		}
		visit = new int[n+1];
		System.out.println(prim());
	}
	
	public static int prim() {
		int result = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1,0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (visit[now.v]==0)
				visit[now.v]=1;
			else 
				continue;
			result += now.w;
			for (int i=0; i<g[now.v].size(); i++) {
				Node next = g[now.v].get(i);
				if (visit[next.v]==0)
					pq.offer(next);
			}
		}
		return result;
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