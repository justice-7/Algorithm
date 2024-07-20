import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][][] matrix, visit;
	static int n,m,h,result;
	static Queue<Node> q;
	static int[] dx={0,0,1,-1,0,0}, dy={1,-1,0,0,0,0}, dh={0,0,0,0,1,-1};

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); //열
		n = Integer.parseInt(st.nextToken()); //행
		h = Integer.parseInt(st.nextToken()); //높이
		matrix = new int[h][n][m];
		visit = new int[h][n][m];
		q = new LinkedList<>();
		for (int i=0; i<h; i++) {
			for (int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k=0; k<m; k++) {
					matrix[i][j][k] = Integer.parseInt(st.nextToken());
					if (matrix[i][j][k]==1) {
						q.add(new Node(i,j,k));
						visit[i][j][k] = 1;
					}
					else if (matrix[i][j][k]==-1) {
						visit[i][j][k]=1;
					}
				}
			}
		}
		result=-1;
		bfs();
		loop:
			for (int i=0; i<h; i++) {
				for (int j=0; j<n; j++) {
					for (int k=0; k<m; k++) {
						if (visit[i][j][k]==0) {
							result=-1;
							break loop;
						}
					}
				}
			}
		System.out.println(result);
	}

	public static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			result++;
			for (int i=0; i<size; i++) {
				Node now = q.poll();
				for (int j=0; j<6; j++) {
					int nh = now.h+dh[j];
					int nx = now.x+dx[j];
					int ny = now.y+dy[j];
					if (nh<0 || nh>=h || nx<0 || nx>=n || ny<0 || ny>=m)
						continue;
					if (matrix[nh][nx][ny]==0 && visit[nh][nx][ny]==0) {
						q.add(new Node(nh,nx,ny));
						visit[nh][nx][ny]=1;
					}
				}
			}
		}
	}

	public static class Node{
		int h;
		int x;
		int y; 
		public Node(int h, int x, int y) {
			this.h=h;
			this.x=x;
			this.y=y;
		}
	}
}