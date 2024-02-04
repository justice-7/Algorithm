import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r,c, result=0;
	static int[] dx={0,0,1,-1}, dy={1,-1,0,0};
	static char[][] board;
	static int[] al = new int[26];

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new char [r][c];
		for (int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine(),"");
			String s = st.nextToken();
			for (int j=0; j<c; j++)
				board[i][j] = s.charAt(j);
		}
		al[board[0][0]-65]=1;
		sol(0,0,1);
		System.out.println(result);
	}

	public static void sol(int x, int y, int cnt) {
		result = Math.max(result, cnt);
		for (int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if (nx<0 || nx>=r || ny<0 || ny>=c)
				continue;
			if (al[board[nx][ny]-65]==0) {
				al[board[nx][ny]-65]=1;
				sol(nx, ny, cnt+1);
				al[board[nx][ny]-65]=0;
			}
		}
	}
}