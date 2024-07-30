import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] minute = new int[n+1];
		st = new StringTokenizer(br.readLine());
		int start = 0;
		for (int i=1; i<=n; i++) {
			int a = Integer.parseInt(st.nextToken());
			start = Math.max(a, start);
			minute[i] = minute[i-1]+a;
		}
		int end = minute[n];
		while (start<=end) {
			int mid = start+((end-start)/2);
			int cnt = 1;
			int ind = 1;
			for (int j=1; j<=n; j++) {
				if (minute[j]-minute[ind-1]>mid) {
					ind = j;
					cnt++;
				}
			}
			if (cnt>m) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		System.out.println(start);
	}
}