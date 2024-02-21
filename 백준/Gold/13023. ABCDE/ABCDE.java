import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * @author justice_va
 * @date 24.02.21
 * @link https://www.acmicpc.net/problem/13023
 * @keyword_solution 그래프(dfs)
 * @input 
 * 사람 수: 5<= N <=2,000
 * 친구 관계 수: 1<= M <= 2,000
 * @output A,B,C,D,E 존재하면 1, 아니면 0
 * @time_complex O(NM)
 * @perf 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m, result;
	static int[] visit,count;
	static List<List<Integer>> g = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i=0; i<n; i++) {
			g.add(new ArrayList<>());
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g.get(a).add(b);
			g.get(b).add(a);
		}
		count = new int[n];
		result=0;
		for (int j=0; j<n; j++) {
			visit = new int[n];
			visit[j]=1;
			dfs(j,1); 
			if (result == 1)
				break;
		}
		System.out.println(result);
	}

	public static void dfs(int x,int cnt) {
		if (result == 1)
			return;
		if (cnt==5) {
			result = 1;
			return;
		}
		for (int i=0; i<g.get(x).size(); i++) {
			if (visit[g.get(x).get(i)]==0) {
				visit[g.get(x).get(i)]=1;
				dfs(g.get(x).get(i),cnt+1);
				visit[g.get(x).get(i)]=0;
			}
		}
	}
}