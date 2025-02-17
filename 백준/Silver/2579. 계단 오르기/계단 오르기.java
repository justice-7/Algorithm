import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		int[] ar = new int[301];
		int[] dp = new int[301];
		for (int i=0; i<n; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = ar[0]; 
		dp[1] = ar[0]+ar[1]; 
		dp[2] = Math.max(ar[0], ar[1])+ar[2];
		for (int j=3; j<n; j++) {
			dp[j] = Math.max(dp[j-3]+ar[j-1],dp[j-2])+ar[j];
		}
		System.out.println(dp[n-1]);
	}

}