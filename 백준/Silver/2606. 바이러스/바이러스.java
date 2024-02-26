import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,e, result =-1;
	static List<Integer>[] g;
	static int[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		g = new ArrayList[n+1];
		visit = new int[n+1];
		for (int j=1; j<=n; j++) {
			g[j] = new ArrayList<>();
		}
		for (int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			g[b].add(a);
		}
		dfs(1);
		System.out.println(result);
	}
	
	public static void dfs(int v) {
		visit[v]=1;
		result++;
		for (int i=0; i<g[v].size(); i++) {
			int next = g[v].get(i);
			if (visit[next]==0) {
				dfs(next);
			}
		}
	}

}