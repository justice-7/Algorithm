import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] ar = new int[n];
		for (int i=0; i<n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ar);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int j=0; j<m; j++) {
			int find = Integer.parseInt(st.nextToken());
			int start = 0;
			int end =n-1;
			int result = 0;
			while (start<=end) {
				int mid = (start+end)/2;
				if (find == ar[mid]) {
					result = 1;
					break;
				}
				else if (find < ar[mid]) {
					end = mid-1;
				}
				else {
					start = mid+1;
				}
			}
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}