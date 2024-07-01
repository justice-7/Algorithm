import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,l;
	static int[] water;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		water = new int[n];
		for (int i=0; i<n; i++) {
			water[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(water);
		float end = 0.0f;
		int result = 0;
		for (int j=0; j<n; j++) {
			if (end >= water[j]+0.5) {
				continue;
			}
			result++;
			end = (float) (water[j]+l-0.5);	
		}
		System.out.println(result);
	}
}