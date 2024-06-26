import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		char[][] ans = new char[5][15];
		for (int i=0; i<5; i++) {
			String s = br.readLine();
			for (int j=0; j<s.length(); j++) {
				ans[i][j] = s.charAt(j);
			}
		}
		for (int i=0; i<15; i++) {
			for (int j=0; j<5; j++) {
				if (ans[j][i]!='\0')
					sb.append(ans[j][i]);
			}
		}
		System.out.println(sb);
	}

}