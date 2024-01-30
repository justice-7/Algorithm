import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visit;
	static int n,m;
	static int[] num;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[m];
		visit = new boolean[n+1];
		p(0);
		System.out.println(sb);
	}
	
	public static void p(int cnt) {
		if (cnt == m) {
			for (int j=0; j<m; j++) {
				sb.append(num[j]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i=1; i<=n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				num[cnt] = i; 
				p(cnt+1);
				visit[i]=false;
			}
		}
	}
}