import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,result;
	static Integer[] a,b;
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		a = new Integer[n];
		b = new Integer[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int j=0; j<n; j++) {
			b[j] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		result = 0;
		for (int k=0; k<n; k++) {
			result+=a[k]*b[k];
		}
		System.out.println(result);
	}

}