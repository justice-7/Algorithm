import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static List<List<Node>> g = new ArrayList<>();
	static int[] visit;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for (int i=0; i<=n; i++)
			g.add(new ArrayList<>());
		result = new int[n+1][n+1];
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			g.get(a).add(new Node(b,w));
			g.get(b).add(new Node(a,w));
		}
		for (int j=1; j<=n; j++) {
			dijk(j);
		}
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if (result[i][j]==0)
					System.out.print("- ");
				else
					System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void dijk(int x) {
		visit = new int[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.w, o2.w));
		dist[x] = 0;
		pq.add(new Node(x,0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if (visit[now.v]!=0)
				continue;
			visit[now.v] = 1;
			for (Node next: g.get(now.v)) {
				if (visit[next.v]==0 && dist[next.v]>dist[now.v]+next.w) {
					dist[next.v] = dist[now.v]+next.w;
					pq.add(new Node(next.v, dist[next.v]));	
					if (now.v==x) {
						result[x][next.v] = next.v;
					}
					else {
						result[x][next.v] = result[x][now.v];
					}
				}
			}
		}
	}

	public static class Node{
		int v; 
		int w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}