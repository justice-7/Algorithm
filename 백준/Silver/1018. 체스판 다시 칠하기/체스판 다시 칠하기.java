import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m, cntW, cntB;
	static char[][] matrix;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		matrix = new char[n][m];
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			for (int j=0; j<m; j++) {
				matrix[i][j] = s.charAt(j);
			}
		}
		int result = 100;
		for (int i=0; i<=n-8; i++) {
			for (int j=0; j<=m-8; j++) {
				cntW = 0;
				cntB = 0;
				check(i,j);
				result = Math.min(result, Math.min(cntW,cntB));
			}
		}
		System.out.println(result);
	}

	public static void check(int r, int c) {
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if (i%2==0) {
					if (j%2==0) {
						if (matrix[r+i][c+j]!='W')
							cntW++;
						else
							cntB++;
						
					}
					else {
						if (matrix[r+i][c+j]=='W')
							cntW++;
						else
							cntB++;
					}
				}
				else {
					if (j%2==0) {
						if (matrix[r+i][c+j]=='W')
							cntW++;
						else 
							cntB++;
					}
					else {
						if (matrix[r+i][c+j]!='W')
							cntW++;
						else 
							cntB++;
					}
				}
			}
		}


	}

}