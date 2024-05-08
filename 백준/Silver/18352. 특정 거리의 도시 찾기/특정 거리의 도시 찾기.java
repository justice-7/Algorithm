import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m, k, x;
	static List<List<Integer>> ar;
	static int[] visit;
	static List<Integer> result;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		ar = new ArrayList<>();
		for (int j=0; j<n+1; j++) {
			ar.add(new ArrayList<Integer>());
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ar.get(a).add(b);
		}
		visit = new int[n+1];
		Arrays.fill(visit, -1);
		result = new ArrayList<Integer>();
		bfs();
		int ok = 0;
		for (int y=1; y<n+1; y++) {
			if (visit[y]==k) {
				sb.append(y+"\n");
				ok=1;
			}
		}
		if (ok==1)
			System.out.println(sb);
		else
			System.out.println(-1);

	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		visit[x]=0;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int next: ar.get(now)) {
				if (visit[next]==-1) {
					q.add(next);
					visit[next] = visit[now]+1;
				}
			}
		}
	}

}