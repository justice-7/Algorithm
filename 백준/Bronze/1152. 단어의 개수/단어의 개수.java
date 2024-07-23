import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		String[] s = br.readLine().trim().split(" ");
		System.out.println(s[0].equals("")? 0 : s.length);
	}
}