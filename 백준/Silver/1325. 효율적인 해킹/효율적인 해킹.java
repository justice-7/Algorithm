import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,m,a,b,cnt,maxCnt=0;
	static List<List<Integer>> g = new ArrayList<List<Integer>>();
	static int[] visit, result;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		for(int i=0; i<=n; i++) {
			g.add(new ArrayList<Integer>());
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			g.get(b).add(a);
		}
		result = new int[n+1];
		int maxCnt=0;
		for(int j=1; j<=n; j++) {
			visit = new int[n+1];
			cnt=0;
			dfs(j);
			result[j] = cnt;
			maxCnt = Math.max(maxCnt, result[j]);
		}
		for (int k=1; k<=n; k++) {
			if (result[k]==maxCnt) {
				sb.append(k+" ");
			}
		}
		System.out.println(sb);
	}

	public static void dfs(int x) {
		visit[x]=1;
		cnt++;
		for (int next: g.get(x)) {
			if (visit[next]==0) {
				dfs(next);
			}
		}
	}
}