import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,m; 
	static int[] ar;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ar = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ar);
		visit = new boolean[n];
		com(0,0, new int[m]);
		System.out.println(sb);
	}
	
	public static void com(int cnt, int start, int[] a) {
		if (cnt==m) {
			for (int x:a)
				sb.append(x+" ");
			sb.append("\n");
			return;
		}
		for (int i=start; i<n; i++) {
			if (!visit[i]) {
				visit[i]=true;
				a[cnt] = ar[i];
				com(cnt+1, i+1, a);
				visit[i]=false;
			}
			
		}
	}
}