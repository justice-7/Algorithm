import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V,E,k,u,v,w;
	static List<List<Node>> g = new ArrayList<List<Node>>();
	static int[] result,visit;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		for (int i=0; i<=V; i++) {
			g.add(new ArrayList<>());
		}
	
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			g.get(u).add(new Node(v,w));
		}
		visit = new int[V+1];
		result = new int[V+1];
		Arrays.fill(result, 1000000);
		dijk();
		for (int j=1; j<=V; j++) {
			sb.append(result[j]==1000000?"INF":result[j]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dijk() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(k,0));
		result[k] = 0;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (visit[now.x]==1)
				continue;
			visit[now.x] = 1;
			for(Node next: g.get(now.x)) {
				if (result[next.x] > result[now.x]+next.w) {
					result[next.x] = result[now.x]+next.w;
					pq.add(new Node(next.x, result[next.x]));
				}
			}
			
		}
	}
	
	public static class Node implements Comparable<Node>{
		int x;
		int w;
		public Node(int x, int w) {
			super();
			this.x = x;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

}