import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * @author justice_va
 * @date 24.03.28
 * @link https://www.acmicpc.net/problem/3055
 * @keyword_solution bfs
 * 빈곳:., 물:*, 돌:X
 * 비버 굴:D, 고슴도치 위치: S
 * 고슴도치, 물: 상하좌우 이동 
 * @input 
 * 지도 크기 R*C: 1 <= R,C <= 50
 * bfs 사용(O(n^2)) : (50*50)^2 = 6,250,000 => 가능
 * @output 고슴도치가 비버 굴로 이동할 수 있는 가장 빠른 시간
 * 이동할 수 없으면 "KAKTUS"
 * @time_complex 
 * @perf O(RC)
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r,c,result = -1;
	static boolean end = false;
	static char map[][];
	static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
	static Queue<Node> q;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		q = new LinkedList<>();
		for (int i=0; i<r; i++) {
			String tmp = br.readLine();
			for (int j=0; j<c; j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j]=='*') 
					q.add(new Node(i, j, '*'));
			}
		}
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (map[i][j]=='S')
					q.add(new Node(i, j, 'S'));
			}
		}
		bfs();
		System.out.println(result==-1?"KAKTUS":result);
	}

	public static void bfs() {
		int cnt = 0;
		while (!q.isEmpty()) {
			if (end)
				break;
			int size = q.size();
			++cnt;
			while(size-->0) {
				if (end)
					break;
				Node now = q.poll();
				for (int i=0; i<4; i++) {
					int nx = now.r+dx[i];
					int ny = now.c+dy[i];
					if (nx<0 || nx>=r || ny<0 || ny>=c)
						continue;
					if (map[nx][ny]=='D' && now.shape=='S') {
						result = cnt;
						end = true;
						break;
					}
					if (map[nx][ny]=='.') {
						map[nx][ny] = now.shape;
						q.add(new Node(nx, ny, now.shape));
					}
				}
			}
		}
	}

	public static class Node {
		int r; 
		int c;
		char shape;
		public Node(int r, int c, char shape) {
			super();
			this.r = r;
			this.c = c;
			this.shape = shape;
		}
	}
}