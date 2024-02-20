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
 * @date 24.02.20
 * @link https://www.acmicpc.net/problem/2636
 * @keyword_solution bfs
 * 1. bfs 돌면서 가장자리 치즈 녹이기
 * 2. 더이상 녹을 치즈가 없을 때까지 반복
 * @input 
 * 세로: 1 <= r <= 100
 * 가로: 1 <= c <= 100
 * @output 
 * 치즈가 모두 녹는데 걸리는 시간
 * 모두 녹기 한 시간 전에 남아있는 치즈조각 수
 * @time_complex O(RC)
 * @perf 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r,c, cnt=1, total=0;
	static int[][] a,visit;
	static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	static List<Integer> cntList = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		a = new int[r][c];
		for (int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<c; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (cnt!=0) {
			visit = new int[r][c];
			cnt=0;
			bfs();
			++total;
			cntList.add(cnt);
		}
		System.out.println(total-1);
		System.out.println(cntList.get(cntList.size()-2));
	}

	public static void bfs() {
		Queue<Node> q = new ArrayDeque<Node>();
		q.offer(new Node(0,0));
		visit[0][0] = 1;
		while (!q.isEmpty()) {
			Node now = q.poll();
			for (int i=0; i<4; i++) {
				int nx = now.x+dir[i][0];
				int ny = now.y+dir[i][1];
				if (nx<0 || nx>=r || ny<0 || ny>=c)
					continue;
				if (visit[nx][ny]==0) {
					visit[nx][ny] = 1;
					if (a[nx][ny]==0)
						q.offer(new Node(nx,ny));
					else {
						a[nx][ny] = 0;
						cnt++;
					}
				}
			}
		}
	}

	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}