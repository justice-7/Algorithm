import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static int[] a;
	public static void main(String[] args) throws Exception{
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int j=0; j<m; j++) {
			int b = Integer.parseInt(st.nextToken());
			if (ok(b)) {
				sb.append("1 ");
			}
			else {
				sb.append("0 ");
			}
		}
		System.out.println(sb);
	}
	public static boolean ok(int num) {
		int start = 0;
		int end = n-1;
		while (start<=end) {
			int mid = start+(end-start)/2;
			if (num==a[mid]) {
				return true;
			}
			else if (num>a[mid]) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return false;
	}

}