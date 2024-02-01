import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, result=1000000000;
	static int[] arrS,arrB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		arrS = new int[n];
		arrB = new int[n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arrS[i] = Integer.parseInt(st.nextToken());
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		sol(0,1,0);
		System.out.println(result);
	}

	public static void sol(int cnt, int s, int b) {
		if (cnt == n) {
			if (b!=0) {
				if (result > Math.abs(s-b))
					result = Math.abs(s-b);
			}
			return;
		}
		sol(cnt+1, s*arrS[cnt],b+arrB[cnt]);
		sol(cnt+1, s, b);
	}
}