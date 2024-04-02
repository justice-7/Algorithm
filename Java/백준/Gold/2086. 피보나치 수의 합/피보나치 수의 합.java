import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * @author justice_va
 * @date 24.04.02
 * @link https://www.acmicpc.net/problem/2086
 * @keyword_solution 피보나치
 * 피보나치 수열의 n까지의 합 = f(n+2) - 1
 * a부터 b까지의 합 = F(b+2)-F(a+1)
 * 뺄 때, 음수나올 수 있으므로 MOD 더하고 나머지 구하기
 * @input 1<= a <= b <= 90^18 => long 범위
 * @output a번쨰 항부터 b번쨰 항까지의 합
 * @time_complex 
 * @perf 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static final long MOD = 1000000000;
	static Map<Long, Long> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		map.put(1L, 1L);
		map.put(2L, 1L);
		long one = fibo(a+1)-1;
		long two = fibo(b+2)-1;
		System.out.println((two-one+MOD)%MOD);
	}
	
	public static long fibo(long n) {
		if (map.containsKey(n))
			return map.get(n);
		if (n%2==1)
			map.put(n, (fibo(n/2)*fibo(n/2)+fibo(n/2+1)*fibo(n/2+1))%MOD);
		else 
			map.put(n, (fibo(n+1)-fibo(n-1)+MOD)%MOD);
		return map.get(n);
	}

}