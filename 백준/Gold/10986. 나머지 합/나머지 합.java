import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] sum = new int[n+1];
		long[] remainCnt = new long[m];
		st = new StringTokenizer(br.readLine());
		long result = 0;
		remainCnt[0]=1;
		for (int i=1; i<=n; i++) {
			sum[i] = (sum[i-1]+(Integer.parseInt(st.nextToken()))%m)%m;
			remainCnt[sum[i]]++;
		}
		for (int j=0; j<m; j++) {
			if (remainCnt[j]!=0) {
				result+=(remainCnt[j]*(remainCnt[j]-1))/2;
			}
		}
		System.out.println(result);
	}
}