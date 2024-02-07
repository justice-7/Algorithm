import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,x,y;
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		int [][] a = new int[100][100];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for (int j=0; j<10; j++) {
				for (int k=0; k<10; k++) {
					a[x+j][y+k] = 1;
				}
			}
		}
		int result = 0;
		for (int i=0; i<100; i++) {
			for (int j=0; j<100; j++) {
				if (a[i][j]==1)
					result++;
			}
		}
		System.out.println(result);
	}
}