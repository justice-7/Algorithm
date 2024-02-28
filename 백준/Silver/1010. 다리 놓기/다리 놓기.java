import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author justice_va
 * @date 24.02.28
 * @link https://www.acmicpc.net/problem/1010
 * @keyword_solution 조합, 파스칼의 삼각형
 * 서쪽 n개, 동쪽 m개 사이트
 * 서쪽 사이트와 동쪽 사이트 연결 / 한 사이트에 최대 한 개 연결
 * 최대한 다리 많이 짓기 (n개만큼) / 다리 겹칠 수 X
 * @input 
 * 서쪽 사이트 개수n, 동쪽 사이트 개수 m: 0 < n <= m < 30
 * @output 다리를 지을 수 있는 경우의 수
 * @time_complex 
 * @perf 
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t,n,m;
	static int[][] dp = new int[30][30];;
	public static void main(String[] args) throws NumberFormatException, IOException {
		t = Integer.parseInt(br.readLine());
		comb();
		for (int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			System.out.println(dp[m][n]);
		}
	}
	
	public static void comb () {
		for (int i=1; i<30; i++) {
			dp[i][1] = i;
			dp[i][i] = 1;
		}
		for (int j=2; j<30; j++) {
			for (int k=2; k<j; k++) {
					dp[j][k] = dp[j-1][k-1]+dp[j-1][k];
			}
		}
	}
}