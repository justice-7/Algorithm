import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		dp[1] = 0;
		for (int i=2; i<=n; i++) {
			dp[i] = dp[i-1]+1;
			//2, 3 모두로 나누어 떨이지는 경우, if-if로 계산해서 더 적은 경우 선택
			if (i%2==0)
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			if (i%3==0)
				dp[i] = Math.min(dp[i], dp[i/3]+1);
		}
		System.out.println(dp[n]);
		sc.close();
	}

}