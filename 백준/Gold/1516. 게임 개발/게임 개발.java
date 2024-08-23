import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n;
	static List<List<Integer>> g = new ArrayList<List<Integer>>();
	static int[] time, depth, result;
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		for (int i=0; i<=n; i++) {
			g.add(new ArrayList<Integer>());
		}
		time = new int[n+1];
		depth = new int[n+1];
		result = new int[n+1];
		for (int j=1; j<=n; j++) {
			st = new StringTokenizer(br.readLine());
			time[j] = Integer.parseInt(st.nextToken());
			result[j] = time[j];
			int a = Integer.parseInt(st.nextToken());
			while (a != -1) {
				g.get(a).add(j);
				depth[j]++;
				a = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for(int k=1; k<=n; k++) {
			if (depth[k]==0) {
				q.add(k);
			}
		}
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next: g.get(now)) {
				result[next] = Math.max(result[next], result[now]+time[next]);
				if (--depth[next]==0) {
					q.add(next);
				}
			}
		}
		for (int k=1; k<=n; k++) {
			sb.append(result[k]+"\n");
		}
		System.out.println(sb);
	}
}