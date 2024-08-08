import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,k, cnt=0;
	static int[] visit = new int[100001];
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(cnt);
	}
	public static void bfs() {
		Queue<Integer> q=  new LinkedList<Integer>();
		q.add(n);
		visit[n]=1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i<size; i++) {
				int now = q.poll();
				if (now==k)
					return;
				if (now+1<=100000 && visit[now+1]==0) {
					q.add(now+1);
					visit[now+1]=1;
				}
				if (now-1>=0 && visit[now-1]==0) {
					q.add(now-1);
					visit[now-1]=1;
				}
				if (now*2<= 100000 && visit[now*2]==0) {
					q.add(now*2);
					visit[now*2]=1;
				}
			}
			cnt++;
		}
	}
}