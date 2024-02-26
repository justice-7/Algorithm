import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/**
 * @author justice_va
 * @date 24.02.26
 * @link https://www.acmicpc.net/problem/4485
 * @keyword_solution 다익스트라
 * @input 
 * 동굴의 크기 n: 2 ~ 125
 * 루피 크기: 0~9
 * @output 링크가 잃을 수 밖에 없는 최소 금액
 * @time_complex 
 * @perf 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n;
	static int[][] matrix,dijk;
	static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		int ind = 1;
		while(true) { 
			n = Integer.parseInt(br.readLine());
			if (n==0)
				break;
			matrix = new int[n][n];
			dijk = new int[n][n];
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					dijk[i][j] = Integer.MAX_VALUE;
				}	
			}
			sb.append("Problem ").append(ind++).append(": ").append(dijk()).append("\n");
		}
		System.out.println(sb);
	}

	public static int dijk() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, matrix[0][0]));
		dijk[0][0] = matrix[0][0];
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			for (int i=0; i<4; i++) {
				int nx = now.x+dir[i][0];
				int ny = now.y+dir[i][1];
				if (nx<0 || nx>=n || ny<0 || ny>=n)
					continue;
				if (dijk[nx][ny] > dijk[now.x][now.y]+matrix[nx][ny]) {
					dijk[nx][ny] = dijk[now.x][now.y]+matrix[nx][ny];
					pq.offer(new Node(nx,ny,dijk[nx][ny]));
				}
			}
		}
		return dijk[n-1][n-1];
	}

	public static class Node implements Comparable<Node> {
		int x;
		int y;
		int w;
		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}
}