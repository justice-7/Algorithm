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
	static int n;
	static List<List<Integer>> g;
	static int[] result, visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		result = new int[n+1];
		visit = new int[n+1];
		g = new ArrayList<>();
		for (int k=0; k<=n; k++) {
			g.add(new ArrayList<Integer>());
		}
		for (int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g.get(a).add(b);
			g.get(b).add(a);
		}
		bfs(1);
		for (int j=2; j<=n; j++) {
			sb.append(result[j]+"\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs(int a) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		visit[a]=1;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i=0; i<g.get(now).size(); i++) {
				int next = g.get(now).get(i);
				if (visit[next]==0) {
					visit[next]=1;
					result[next]=now;
					q.add(next);
				}
			}
		}
	}
}