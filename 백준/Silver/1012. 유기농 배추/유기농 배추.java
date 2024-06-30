import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int t,m,n,k,x,y,result;
	static int[][] matrix, visit;
	static int[] dx= {1,-1,0,0}, dy= {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			matrix = new int[n][m];
			visit = new int[n][m];
			for (int j=0; j<k; j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				matrix[y][x]=1;
			}

			result = 0;
			for (int r=0; r<n; r++) {
				for (int c=0; c<m; c++) {
					if (matrix[r][c]==1 && visit[r][c]==0) {
						result++;
						visit[r][c]=1;
						bfs(r,c);
					}
				}
			}
			System.out.println(result);
		}
	}

	public static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(r,c));
		while(!q.isEmpty()) {
			Node now = q.poll();
			for (int i=0; i<4; i++) {
				int nx = now.r+dx[i];
				int ny = now.c+dy[i];
				if (nx<0 || nx>=n || ny<0 || ny>=m)
					continue;
				if (matrix[nx][ny]==1 && visit[nx][ny]==0) {
					visit[nx][ny]=1;
					q.add(new Node(nx,ny));
				}
			}
		}
	}

	public static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}