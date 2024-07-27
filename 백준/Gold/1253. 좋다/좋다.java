import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int result = 0;
		for (int j=0; j<n; j++) {
			int start = 0;
			int end = n-1;
			while (start<end) {
				if (start==j) {
					start++;
					continue;
				}
				else if (end==j) {
					end--;
					continue;
				}
				if (a[start]+a[end]==a[j]) {
					result++;
					break;
				}
				else if (a[start]+a[end]<a[j]) {
					start++;
				}
				else {
					end--;
				}
			}
		}
		System.out.println(result);
	}
}