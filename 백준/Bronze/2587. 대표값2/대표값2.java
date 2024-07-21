import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] ar;
	public static void main(String[] args) throws Exception {
		ar = new int[5];
		int mean = 0;
		for (int i=0; i<5; i++) {
			ar[i] = Integer.parseInt(br.readLine());
			mean+=ar[i];
		}
		Arrays.sort(ar);
		System.out.println(mean/5);
		System.out.println(ar[2]);
	}

}