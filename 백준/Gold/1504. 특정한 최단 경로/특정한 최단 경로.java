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
	static int n,e,a,b,c,v1,v2,max = 2000000;
	static List<List<Node>> g = new ArrayList<>();
	static int[] dist;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		for (int i=0; i<=n; i++) {
			g.add(new ArrayList<>());
		}
		for (int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			g.get(a).add(new Node(b,c));
			g.get(b).add(new Node(a,c));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		int result = 0;
		dijk(v1);
		int v11 = dist[1];
		int v1n = dist[n];
		dijk(v2);
		int v21 = dist[1];
		int v2n = dist[n];
		result = max;
		if (v11!=max && v2n!=max) {
			result = v11+v2n;
		}
		if (v21!=max && v1n!=max)
		{
			result = Math.min(result, v21+v1n);
		}
		if (result==max || dist[v1]==max)
			System.out.println(-1);
		else 
			System.out.println(result+dist[v1]);
	}
	public static void dijk(int x) {
		dist = new int[n+1];
		Arrays.fill(dist, max);
		dist[x]=0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(x,0));
		while(!pq.isEmpty()){
			Node now = pq.poll();
			if (dist[now.v] < now.w)
				continue;
			for (Node next: g.get(now.v)) {
				if (dist[next.v] > dist[now.v]+next.w) {
					dist[next.v] = dist[now.v]+next.w;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}
	public static class Node implements Comparable<Node>{
		int v;
		int w;
		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
}