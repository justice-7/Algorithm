import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a==0 && b==0  && c==0) {
				break;
			}
			if (a>b && a>c && Math.pow(a,2)==Math.pow(b, 2)+Math.pow(c, 2)) {
				System.out.println("right");
			}
			else if (b>a && b>c && Math.pow(b,2)==Math.pow(a, 2)+Math.pow(c, 2)) {
				System.out.println("right");
			}
			else if (c>a && c>b && Math.pow(c,2)==Math.pow(a, 2)+Math.pow(b, 2)) {
				System.out.println("right");
			}
			else {
				System.out.println("wrong");
			}
		}
	}

}