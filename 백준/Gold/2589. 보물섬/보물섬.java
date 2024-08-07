import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r,c, result, cnt;
	static char[][] matrix;
	static int[][] visit;
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		matrix = new char[r][c];
		for (int i=0; i<r; i++) {
			String s = br.readLine();
			for (int j=0; j<c; j++) {
				matrix[i][j] = s.charAt(j);
			}
		}
		result = 0;
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (matrix[i][j]=='L') {
					visit = new int[r][c];
					result = Math.max(result, bfs(i,j));
				}
			}
		}
		System.out.println(result);
	}

	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		visit[x][y] = 1;
		int cnt = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int j=0; j<size; j++) {
				Node now = q.poll();
				for (int i=0; i<4; i++) {
					int nx = now.x+dx[i];
					int ny = now.y+dy[i];
					if (nx<0 || ny<0 || nx>=r || ny>=c)
						continue;
					if (matrix[nx][ny]=='L' && visit[nx][ny]==0) {
						visit[nx][ny]=visit[now.x][now.y]+1;
						q.add(new Node(nx,ny));
					}
				}
			}
		}
		return cnt;
	}

	public static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}