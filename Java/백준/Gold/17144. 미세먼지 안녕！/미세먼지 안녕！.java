import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
 * @author justice_va
 * @date 24.04.03
 * @link https://www.acmicpc.net/problem/17144
 * @keyword_solution 구현
 * r*c
 * -1: 공기 청정기 설치
 * 나머지: 미세먼지 양
 * 확산은 모든 칸에 동시에
 * 확산 양: Ar,c/5
 * (r,c)에 남은 미세먼지 양: Ar,c - (Ar,c/5)*(확산된 방향 개수)
 * 위쪽 공기 청정기: 반시계 / 아래쪽 공기청정기: 시계
 * @input 
 * 6 <= r,c <= 50
 * 1 <= t <= 1,000
 * -1 <= Ar,c <= 1,000
 * @output 
 * @time_complex 
 * @perf 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; 
	static StringBuilder sb = new StringBuilder();
	static int r,c,t, cnt;
	static int[][] map, dust;
	static int[] dx= {1,-1,0,0}, dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		
		List<Integer> airRow = new ArrayList<>();
		for (int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==-1) {
					airRow.add(i);
				}
			}
		}
		for (int x=0; x<t; x++) {
			dust = new int[r][c];
			for (int y=0; y<2; y++) {
				dust[airRow.get(y)][0]=-1;
			}
			for (int i=0; i<r; i++) {
				for (int j=0; j<c; j++) {
					cnt = 0;
					int side = map[i][j]/5;
					if (map[i][j]>0) {
						for (int k=0; k<4; k++) {
							int nx = i+dx[k];
							int ny = j+dy[k];
							if (nx<0 || nx>=r || ny<0 || ny>=c)
								continue;
							if (map[nx][ny]!=-1) {
								++cnt;
								dust[nx][ny]+=side;
							}
						}
						dust[i][j]+=map[i][j]-(side*cnt);
					}
				}
			}
			up(airRow.get(0));
			down(airRow.get(1));
			for (int i=0; i<r; i++) {
				for (int j=0; j<c; j++) {
					map[i][j] = dust[i][j];
				}
			}
		}
		int result = 0;
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				result += map[i][j];
			}
		}
		System.out.println(result+2);
	}

	public static void up(int n) {
		int tmp = n-1;
		while (tmp>0) {
			dust[tmp][0] = dust[tmp-1][0];
			--tmp;
		}
		tmp = 0;
		while (tmp+1<c) {
			dust[0][tmp] = dust[0][tmp+1];
			++tmp;
		}
		tmp = 0;
		while (tmp<n) {
			dust[tmp][c-1] = dust[tmp+1][c-1];
			++tmp;
		}
		tmp = c-1;
		while (tmp>1) {
			dust[n][tmp] = dust[n][tmp-1];
			--tmp;
		}
		dust[n][1] = 0;
	}

	public static void down(int n) {
		int tmp = n+1;
		while (tmp+1<r) {
			dust[tmp][0] = dust[tmp+1][0];
			++tmp;
		}
		tmp = 0;
		while (tmp+1<c) {
			dust[r-1][tmp] = dust[r-1][tmp+1];
			++tmp;
		}
		tmp = r-1;
		while (tmp>n) {
			dust[tmp][c-1] = dust[tmp-1][c-1];
			--tmp;
		}
		tmp = c-1;
		while (tmp>1) {
			dust[n][tmp] = dust[n][tmp-1];
			--tmp;
		}
		dust[n][1] = 0;
	}
}