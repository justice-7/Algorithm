import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] a = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int x=1; x<=n; x++) {
			a[x]=a[x-1]+Integer.parseInt(st.nextToken());
		}
		for (int y=0; y<m; y++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			sb.append(a[j]-a[i-1]+"\n");
		}
		System.out.println(sb);
	}
}