import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb;
	static int n,cnt;
	static int[][] matrix, visit;
	static int[] dx= {1,-1,0,0}, dy = {0,0,1,-1};
	static List<Integer> ans = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception{
		n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		visit = new int[n][n];
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			for (int j=0; j<n; j++) {
				matrix[i][j] = s.charAt(j)-'0';
			}
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (matrix[i][j]==1 && visit[i][j]==0) {
					visit[i][j]=1;
					cnt = 0;
					bfs(i,j);
					ans.add(cnt);
				}
			}
		}
		System.out.println(ans.size());
		ans.sort(Comparator.naturalOrder());
		//ans.sort((a,b) -> a-b);
		for (int k=0; k<ans.size(); k++) {
			System.out.println(ans.get(k));
		}

	}

	public static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r, c));
		while (!q.isEmpty()) {
			Node now = q.poll();
			cnt++;
			for (int i=0; i<4; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if (nx<0 || nx>=n || ny<0 || ny>=n)
					continue;
				if (matrix[nx][ny]==1 && visit[nx][ny]==0) {
					visit[nx][ny]=1;
					q.add(new Node(nx, ny));
				}
			}
		}
	}

	public static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}