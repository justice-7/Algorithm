import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int result = -1;
		while (n>=0) {
			if (n%3==0) {
				result = cnt+n/3;
			}
			n-=5;
			cnt++;
		}
		System.out.println(result);
	}
}