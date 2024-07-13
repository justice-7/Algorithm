import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception{
		String[] s = br.readLine().split(" ");
		int result = -1;
		for (int i=2; i>=0; i--) {
			if (s[0].charAt(i)<s[1].charAt(i)) {
				result = 1;
				break;
			}
			else if (s[0].charAt(i)>s[1].charAt(i)){
				result = 0;
				break;
			}
		}
		for (int j=2; j>=0; j--) {
			System.out.print(s[result].charAt(j));
		}
	}
}