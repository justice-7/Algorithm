import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 트리의 성질 아는 것이 중요
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int v, maxV=0, maxDist=0;
	static List<List<Node>> g = new ArrayList<List<Node>>();
	static int[] visit;
	public static void main(String[] args) throws Exception{
		v = Integer.parseInt(br.readLine());
		for (int i=0; i<=v; i++) {
			g.add(new ArrayList<Node>());
		}
		visit = new int[v+1];
		for (int j=0; j<v; j++) {
			st=  new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int u = Integer.parseInt(st.nextToken());
			while (u!=-1) {
				g.get(n).add(new Node(u,Integer.parseInt(st.nextToken())));
				u = Integer.parseInt(st.nextToken());
			}
		}
		dfs(1,0);
		visit = new int[v+1];
		maxDist=0;
		dfs(maxV,0);
		System.out.println(maxDist);
	}
	
	public static void dfs(int n, int dist) {
		visit[n]=1;
		if (maxDist<dist) {
			maxDist = dist;
			maxV = n;
		}
		for (Node now:g.get(n)) {
			if (visit[now.u]==0) {
				dfs(now.u, dist+now.w);
			}
		}
		
	}
	public static class Node{
		int u;
		int w;
		public Node(int u, int w) {
			super();
			this.u = u;
			this.w = w;
		}
	}
}