import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		boolean[] seat = new boolean[101];
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (seat[a]) 
				cnt++;
			else 
				seat[a]=true;
		}
		System.out.println(cnt);
	}
}