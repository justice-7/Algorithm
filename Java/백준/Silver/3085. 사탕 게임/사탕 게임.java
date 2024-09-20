import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, result;
	static int[][] map;
	static int[] dx={1,0}, dy={0,1};
	public static void main(String[] args) throws Exception{
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			for (int j=0; j<n; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		result = 0;
		end: for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<2; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					if (nx>=n || ny>=n)
						continue;
					if (map[i][j]!=map[nx][ny]) {
						swap(i, j, nx, ny);
						count();
						swap(i, j, nx, ny);
					}
					if (result == n)
						break end;
				}
				
			}
		}
		
		System.out.println(result);
	}
	
	public static void swap(int x, int y, int nx, int ny) {
		int tmp = map[x][y];
		map[x][y] = map[nx][ny];
		map[nx][ny] = tmp;
	}
	
	public static void count() {
		for (int i=0; i<n; i++) {
			int row = 1;
			int col = 1;
			for (int j=0; j<n-1; j++) {
				if (map[i][j]==map[i][j+1])
					row++;
				else 
					row=1;
				result = Math.max(result, row);
				
			}
			for (int j=0; j<n-1; j++) {
				if (map[j][i]==map[j+1][i])
					col++;
				else 
					col=1;
				result = Math.max(result, col);
			}
			
		}
	}
}