import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		for (int i=1; i<=n; i++) {
			for (int j=n-i; j>0; j--) {
				sb.append(" ");
			}
			for (int k=0; k<i; k++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}