import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] ar = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ar);
		int start = 0;
		int end = n-1;
		int result = 0;
		while (start<end) {
			if (ar[start]+ar[end]==m) {
				result++;
				start++;
				end--;
			}
			else if (ar[start]+ar[end]<m) {
				start++;
			}
			else {
				end--;
			}
		}
		System.out.println(result);
	}
	
}