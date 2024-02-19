import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static char[][] matrix;
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		matrix = new char[n][n];
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			for (int j=0; j<n; j++) {
				matrix[i][j] = s.charAt(j);
			}
		}
		sol(0,0,n);
		System.out.println(sb);
	}
	
	public static void sol(int x, int y, int size) {
		
		if (what(x,y,size)==1) {
			sb.append(1);
			return;
		}
		else if (what(x,y,size)==0) {
			sb.append(0);
			return ;
		}
		else {
			sb.append("(");
			sol(x,y,size/2);
			sol(x,y+size/2,size/2);
			sol(x+size/2, y, size/2);
			sol(x+size/2, y+size/2, size/2);
			sb.append(")");
		}
	}
	public static int what(int x, int y, int size) {
		int sum=0;
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (matrix[x+i][y+j] == '1')
					sum++;
			}
		}
		if (sum==size*size)
			return 1;
		else if (sum==0)
			return 0;
		else 
			return -1;
	}
}