import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] matrix, visit;
	static int m,n, result;
	static int[] dx={0,0,-1,1}, dy={1,-1,0,0};
	static Queue<Node> q;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); //열
		n = Integer.parseInt(st.nextToken()); //행
		matrix = new int[n][m];
		visit = new int[n][m];
		q = new LinkedList<>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if (matrix[i][j]==1) {
					q.add(new Node(i,j));
					visit[i][j]=1;
				}
				else if (matrix[i][j]==-1) {
					visit[i][j]=1;
				}
			}
		}
		result = -1;
		bfs();
		for (int r=0; r<n; r++) {
			for (int c=0; c<m; c++) {
				if (visit[r][c]==0) {
					result = -1;
					break;
				}
			}
		}
		System.out.println(result);
	}
	
	public static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			result++;
			for (int i=0; i<size; i++) {
				Node now = q.poll();
				for (int j=0; j<4; j++) {
					int nx = now.x+dx[j];
					int ny = now.y+dy[j];
					if (nx<0 || nx>=n || ny<0 || ny>=m)
						continue;
					if (matrix[nx][ny]==0 && visit[nx][ny]==0) {
						visit[nx][ny]=1;
						q.add(new Node(nx,ny));
					}
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