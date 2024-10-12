import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static List<Node> g = new ArrayList<>();
	static long[] dist;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dist = new long[n+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g.add(new Node(a,b,c));
		}
		if (bf(1))
			System.out.println(-1);
		else {
			for (int j=2; j<=n; j++) {
				System.out.println(dist[j]==Long.MAX_VALUE?-1:dist[j]);
			}
		}
	}
    
	public static boolean bf(int x) {
		dist[x] = 0;
		for (int i=1; i<=n; i++) {
			for (Node now: g) {
				if (dist[now.s] == Long.MAX_VALUE)
					continue;
				if (dist[now.e] > dist[now.s]+now.w) {
					dist[now.e] = dist[now.s]+now.w;
					if (i==n)
						return true;
				}
			}
		}
		return false;
	}
	
	public static class Node{
		int s;
		int e;
		int w;
		public Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
	}

}