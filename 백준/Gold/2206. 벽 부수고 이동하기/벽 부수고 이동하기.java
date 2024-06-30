import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int[][] matrix;
	static int[][][] visit;
	static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix = new int[n][m];
		visit = new int[n][m][2];
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			for (int j=0; j<m; j++) {
				matrix[i][j]= s.charAt(j)-'0';
			}
		}
		visit[0][0][0]=1;
		bfs(0,0);

		int yes = visit[n-1][m-1][1];
		int no = visit[n-1][m-1][0];
		if (no==0) {
			System.out.println(yes==0?-1:yes);
		}
		else if (yes==0){
			System.out.println(no==0?-1:no);
		}
		else
			System.out.println(Math.min(yes, no));
	}

	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node (x,y,0));
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i=0; i<4; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if (nx<0 || nx>=n || ny<0 || ny>=m)
					continue;

				if (matrix[nx][ny]==0 && visit[nx][ny][now.b]==0) {
						q.add(new Node(nx,ny,now.b));
						visit[nx][ny][now.b] = visit[now.x][now.y][now.b]+1;
				}
				else if (now.b==0 && matrix[nx][ny]==1 && visit[nx][ny][1]==0) {
					q.add(new Node(nx,ny,1));
					visit[nx][ny][1] = visit[now.x][now.y][now.b]+1;
				}
			}
		}
	}

	public static class Node{
		int x;
		int y;
		int b;
		public Node(int x, int y, int b) {
			this.x = x;
			this.y = y;
			this.b = b;
		}
	}
}