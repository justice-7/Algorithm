import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int w, h, cnt;
	static int[][] matrix, visit;
	static int[] dx= {0,0,1,-1,1,1,-1,-1}, dy= {1,-1,0,0,1,-1,1,-1};
	public static void main(String[] args) throws Exception {
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w==0 && h==0)
				break;
			matrix = new int[h][w];
			visit = new int[h][w];
			for (int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<w; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			for (int i=0; i<h; i++) {
				for (int j=0; j<w; j++) {
					if (matrix[i][j]==1 && visit[i][j]==0) {
						cnt++;
						bfs(i,j);
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}

	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		visit[x][y] = 1;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i=0; i<8; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if (nx<0 || nx>=h || ny<0 || ny>=w)
					continue;
				if (matrix[nx][ny]==1 && visit[nx][ny]==0) {
					visit[nx][ny]=1;
					q.add(new Node(nx,ny));
				}
			}
		}
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