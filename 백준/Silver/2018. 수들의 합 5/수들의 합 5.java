import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+1];
		for (int i=1; i<=n; i++) {
			a[i]=a[i-1]+i;
		}
		int start = 0;
		int end = 1;
		int result = 0;
		while (start<end && end<=n) {
			if (a[end]-a[start]<n) {
				end++;
			}
			else if (a[end]-a[start]>n) {
				start++;
			}
			else {
				result++;
				end++;
			}
		}
		System.out.println(result);
	}
}