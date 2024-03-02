import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parent; 
	public static void main(String[] args) throws IOException {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(a, b, w));
		}
		
		parent = new int[n+1];
		for (int i=1; i<=n; i++) {
			parent[i]=i;
		}
		
		int cnt =0 ;
		int result = 0;
		while (cnt < n-1) {
			Edge now = pq.poll();
			if (union(now.a,now.b)) {
				cnt++;
				result += now.w;
			}
		}
		System.out.println(result);
		
	}
	
	public static int find(int v) {
		if (v == parent[v])
			return v;
		return find(parent[v]);
	}
	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a==b)
			return false;
		else if (a<b)
			parent[b] = a;
		else
			parent[a] = b;
		return true;
	}
	
	public static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int w;
		public Edge(int a, int b, int w) {
			this.a = a;
			this.b = b;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
	}
}