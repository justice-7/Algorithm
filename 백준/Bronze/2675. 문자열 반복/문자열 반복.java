import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int t;
	public static void main(String[] args) throws NumberFormatException, IOException {
		t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			sb = new StringBuilder();
			for (int j=0; j<s.length(); j++) {
				for (int k=0; k<cnt; k++) {
					sb.append(s.charAt(j));
				}
			}
			System.out.println(sb);
		}
	}
}