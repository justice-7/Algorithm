import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<=i; j++) {
				if (i==0)
					a[i][j] = Integer.parseInt(st.nextToken());
				else if (j==0)
					a[i][j] = a[i-1][j]+ Integer.parseInt(st.nextToken());
				else if (j==i)
					a[i][j] = a[i-1][j-1] + Integer.parseInt(st.nextToken());
				else 
					a[i][j] = Math.max(a[i-1][j-1], a[i-1][j])+Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		for (int k=0; k<n; k++) {
			max = Math.max(a[n-1][k], max);
		}
		System.out.println(max);
	}
}