import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m,u,v;
	static int[][] g;
	static int[] visit;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		g = new int[n+1][n+1];
		visit = new int[n+1];
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			g[u][v] = 1;
			g[v][u] = 1;
		}
		int cnt = 0;
		for (int j=1; j<=n; j++) {
			if (visit[j]==0) {
				dfs(j);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void dfs(int num) {
		for (int i=1; i<=n; i++) {
			if (visit[i]==0 && g[num][i]==1) {
				visit[i]=1;
				dfs(i);
			}
		}
	}
}