import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String n;
	static int b;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());
		int result = 0;
		int a=0;
		for (int i=n.length()-1; i>=0; i--) {
			if (0<=n.charAt(i)-'0' && n.charAt(i)-'0'<=9) {
				a = n.charAt(i)-'0';
			}
			else {
				a = n.charAt(i)-'A'+10;
			}
			result += a*Math.pow(b,(n.length()-1-i));
		}
		System.out.println(result);
	}
}