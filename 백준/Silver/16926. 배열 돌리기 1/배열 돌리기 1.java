import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n,m,r;
	static int[][] a;
	static int[] dx= {1,0,-1,0}, dy={0,1,0,-1};

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		a = new int[n][m];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		for (int k=0; k<Math.min(n,m)/2; k++) {
			sol(k,k,n-(k*2),m-(k*2));
		}

		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				sb.append(a[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void sol(int x, int y, int row, int col) {
		int size = (row+col-2)*2;
		int[] tmp = new int[(size)];
		int ind = 0;
		for (int j=0; j<row-1; j++) {
			tmp[ind+j] = a[x+dx[0]*j][y+dy[0]*j];
			tmp[ind+(row+col-2)+j] = a[x+row-1+dx[2]*j][y+col-1+dy[2]*j];
		}
		for (int k=0; k<col-1; k++) {
			tmp[ind+row-1+k]=a[x+row-1+dx[1]*k][y+dy[1]*k];
			tmp[ind+(row+row+col-3)+k] = a[x+dx[3]*k][y+col-1+dy[3]*k];
		}
		
		ind = size-(r%size);
		for (int j=0; j<row-1; j++) {
			a[x+dx[0]*j][y+dy[0]*j] = tmp[(ind+j)%size]; 
			a[x+row-1+dx[2]*j][y+col-1+dy[2]*j] = tmp[(ind+(row+col-2)+j)%size];
		}
		for (int k=0; k<col-1; k++) {
			a[x+row-1+dx[1]*k][y+dy[1]*k] = tmp[(ind+row-1+k)%size];
			a[x+dx[3]*k][y+col-1+dy[3]*k] = tmp[(ind+(row+row+col-3)+k)%size];
		}
	}
}