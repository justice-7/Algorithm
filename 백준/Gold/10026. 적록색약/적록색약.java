import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
/**
 * @author justice_va
 * @date 24.02.20
 * @link https://www.acmicpc.net/problem/10026
 * @keyword_solution bfs
 * 1. 적록색약이 아닌 사람이 봤을 때의 구역 수 구하기
 * 2. 적록색약인 사람이 봤을 때의 구역 수 구하기
 * @input
 * 배열 크기(n*n): 1<= n <= 100 
 * @output 적록색약X 구역 수 / 적록색약O 구역 수
 * @time_complex O(N^2)
 * @perf
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static char[][] matrix;
	static boolean[][] visit;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		matrix = new char[n][n];
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			for (int j=0; j<n; j++) {
				matrix[i][j] = s.charAt(j);
			}
		}
		sol(); // 색약X
		sol(); // 색약O
		System.out.println(sb);
	}
    
	public static void sol() {
		int result=0;
		visit = new boolean[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (!visit[i][j]) {
					bfs(i,j);
					++result;
				}
			}
		}
		sb.append(result+" ");
	}

	public static void bfs(int x, int y) {
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x,y));
		visit[x][y] = true;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i=0; i<4; i++) {
				int nx = now.x+dir[i][0];
				int ny = now.y+dir[i][1];
				if (nx<0 || nx>=n || ny<0 || ny>=n)
					continue;
				if (!visit[nx][ny] && matrix[nx][ny]==matrix[now.x][now.y]) {
					visit[nx][ny] = true;
					q.offer(new Node(nx,ny));
				}
			}
			if (matrix[now.x][now.y]=='R') {
				matrix[now.x][now.y]='G';
			}
		}
	}

	public static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}