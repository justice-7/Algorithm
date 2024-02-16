import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n,m;
	static List[] g;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken())+1;
		m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		g = new List[n];
		for (int j=0; j<n; j++)
			g[j] = new ArrayList<>();
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		for (int j=0; j<n; j++)
			Collections.sort(g[j]);
		visit = new boolean[n];
		dfs(0,v);
		sb.append("\n");
		visit = new boolean[n];
		bfs(v);
		System.out.println(sb);
	}

	public static void dfs(int cnt, int cur) {
		sb.append(cur+" ");
		visit[cur] = true;
		for (int i=0; i<g[cur].size(); i++) {
			int tmp = (int) g[cur].get(i);
			if (!visit[tmp]) {
				dfs(cnt+1, tmp);
			}
		}
	}

	public static void bfs(int cur) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(cur);
		visit[cur]=true;
		while (!q.isEmpty()) {
			int now = q.poll();
			sb.append(now+" ");
			for (int i=0; i<g[now].size(); i++) {
				int tmp = (int) g[now].get(i);
				if (!visit[tmp]) {
					q.offer(tmp);
					visit[tmp]=true;
				}
			}
		}
	}
}