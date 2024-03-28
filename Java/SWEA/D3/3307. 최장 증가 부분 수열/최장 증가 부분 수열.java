import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * @author 박정의
 * @date 24.03.27
 * @link https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWBOKg-a6l0DFAWr
 * @keyword_solution 최장증가부분수열 LIS
 * @input 
 * 수열의 길이: 1 <= N <= 1,000
 * 원소: 1<= a <= 2^31-1
 * @output 최대 증가 부분 수열 길이
 * @time_complex 
 * @perf 
 */

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] lis,a;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i=1; i<=t; i++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			a = new int[n];
			lis = new int[n];
			result = 0;
			for (int j=0; j<n; j++) {
				a[j] = Integer.parseInt(st.nextToken());
				lis[j]=1;
				for (int k=0; k<j; k++) {
					if (a[k]<a[j] && lis[j]<lis[k]+1) {
						lis[j] = lis[k]+1;
						result = Math.max(result, lis[j]);
					}
				}
			}
			sb.append("#"+i).append(" ").append(result+"\n");
		}
		System.out.println(sb);
	}

}