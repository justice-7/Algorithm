import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		int[] ar = new int[n];
		int[] dp = new int[n];
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
			for(int j=0; j<i; j++) {
				if (ar[j]<ar[i])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result+1);
	}
}