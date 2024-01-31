import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n,m;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		comb(0,1,new int[m]);
		System.out.println(sb);
	}

	public static void comb(int cnt, int start, int[] result) {
		if (cnt == m) {
			for (int i=0; i<m; i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int j=start; j<=n; j++) {
			result[cnt] = j;
			comb(cnt+1, j+1, result);
		}
	}
}