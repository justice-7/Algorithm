import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m,a,b,ok;
	static List<List<Integer>> g;
	static int[] visit;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		g = new ArrayList<>();
		for (int i=0; i<n; i++) {
			g.add(new ArrayList<>());
		}
		visit = new int[n];
		m = Integer.parseInt(st.nextToken());
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			g.get(a).add(b);
			g.get(b).add(a);
		}
		ok = 0;
		for (int j=0; j<n; j++) {
			visit[j]=1;
			dfs(j,0);
			visit[j]=0;
		}
		System.out.println(ok);
	}
	public static void dfs(int node, int cnt) {
		if (cnt==4 || ok==1) {
			ok=1;
			return;
		}
		for (int i=0; i<g.get(node).size(); i++) {
			if (visit[g.get(node).get(i)]==0) {
				visit[g.get(node).get(i)] = 1;
				dfs(g.get(node).get(i), cnt+1);
				visit[g.get(node).get(i)] = 0;
			}
		}
	}
}