import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int m,n;
	static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
	static int[][] map, dp;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		dp = new int[m][n];
		for (int i=0; i<m; i++) {
			st =  new StringTokenizer(br.readLine());
			for (int j=0 ;j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0,0));
	}

	public static int dfs(int x, int y) {
		if (x==m-1 && y==n-1) {
			return 1;
		}
		if (dp[x][y]!=-1)
			return dp[x][y];
		
		dp[x][y]=0;
		for (int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if (nx<0 || nx>= m || ny<0 || ny>=n)
				continue;
			if (map[nx][ny]<map[x][y]) {
				dp[x][y]+=dfs(nx,ny);
			}
		}
		return dp[x][y];
	}
}