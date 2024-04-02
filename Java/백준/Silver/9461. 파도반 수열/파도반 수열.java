import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * @author justice_va
 * @date 24.04.02
 * @link https://www.acmicpc.net/problem/9461
 * @keyword_solution 파도반 수열
 * p(n) = p(n-2)+p(n-3)
 * long 사용
 * @input 1<= n <= 100
 * @output P(n) 출력
 * @time_complex 
 * @perf 
 */

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static long[] ar = new long[101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine());
		ar[1]=1;
		ar[2]=1;
		ar[3]=1;
		for(int i=1; i<=t; i++) {
			int a = Integer.parseInt(br.readLine());
			sb.append(p(a)+"\n");
		}
		System.out.println(sb);
	}

	public static long p(int n) {
		if (n<=2)
			return ar[n];
		if(ar[n]==0) 
			ar[n] = p(n-2)+p(n-3);
		return ar[n];
	}

}