import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author justice_va
 * @date 24.02.29
 * @link https://www.acmicpc.net/problem/14502
 * @keyword_solution 조합, bfs
 * 바이러스 상하좌우 
 * 벽 3개 세우기
 * 안전영역 구하기
 * @input 
 * 세로, 가로: 3 <= n,m <= 8
 * 0: 빈칸, 1: 벽, 2: 바이러스
 * 바이러스 개수: 2 ~ 10
 * 빈칸 개수: 3개 이상 
 * - 조합*bfs = ((n*m)C3) * (n*m) = 2,666,496 => 완탐가능
 * @output 안전 영역의 수
 * @time_complex O((n*m)^4)
 * @perf 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m,result = 0;
	static int [][]matrix;
	static List<Node> birus;
	static int[][] dir = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix = new int[n][m];
		birus = new ArrayList<>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if (matrix[i][j]==2)
					birus.add(new Node(i,j));
			}
		}
		comb(0,0);
		System.out.println(result);
	}
	public static void comb(int cnt, int start) {
		if (cnt == 3) {
			int[][] visit = new int[n][m];
			for(int i=0; i<n; i++) {
				for (int j=0; j<m; j++) {
					visit[i][j] = matrix[i][j];
				}
			}
			result = Math.max(result, safeCal(visit));
			return; 
		}
		for (int i=start; i<n*m; i++) {
			if (matrix[i/m][i%m]==0) {
				matrix[i/m][i%m]=1;
				comb(cnt+1, start+1);
				matrix[i/m][i%m]=0;
			}
		}
	}
	
	public static int safeCal(int[][] visit) {
		Queue<Node> q = new ArrayDeque<>(birus);
		while(!q.isEmpty()){
			Node now = q.poll();
			for (int i=0; i<4; i++) {
				int nx = now.x+dir[i][0];
				int ny = now.y+dir[i][1];
				if (nx<0 || nx>=n || ny<0 || ny>=m) 
					continue;
				if (visit[nx][ny]==0) {
					visit[nx][ny] = 2;
					q.offer(new Node(nx,ny));
				}
			}
		}
		int safe = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (visit[i][j]==0)
					++safe;
			}
		}
		return safe;
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