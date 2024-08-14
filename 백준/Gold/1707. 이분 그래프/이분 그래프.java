import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int k, V, E, u,v;
	static List<List<Integer>> g;
	static int[] visit;
	static boolean ok;
	public static void main(String[] args) throws NumberFormatException, IOException {
		k = Integer.parseInt(br.readLine());
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			g = new ArrayList<List<Integer>>();
			for (int k=0; k<=V; k++) {
				g.add(new ArrayList<Integer>());
			}
			visit = new int[V+1];
			Arrays.fill(visit, -1);
			ok = true;
			for (int j=0; j<E; j++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				g.get(u).add(v);
				g.get(v).add(u);
			}
			for (int k=1; k<=V; k++) {
				if (visit[k]==-1) {
					dfs(k);
					if (!ok)
						break;
				}
			}
			if (ok)
				System.out.println("YES");
			else 
				System.out.println("NO");
		}
	}

	public static void dfs(int n) {
		for (int next: g.get(n)) {
			if (visit[next]==-1) {
				visit[next] = (visit[n]+1)%2;
				dfs(next);
			}
			else if (visit[n]==visit[next]) {
				ok=false;
				return;
			}
		}
	}

}