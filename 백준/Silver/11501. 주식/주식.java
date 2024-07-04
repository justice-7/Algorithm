import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int t, n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			n = Integer.parseInt(br.readLine());
			int[] price = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				price[j] = Integer.parseInt(st.nextToken());
			}
			int big = price[n-1];
			long result = 0;
			for (int j=n-2; j>=0; j--) {
				if (big<price[j]) {
					big = price[j];
				}
				else {
					result += big-price[j];
				}
			}
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}

}