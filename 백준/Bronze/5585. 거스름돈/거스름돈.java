import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] money = {500,100,50,10,5,1};
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		n = 1000-n;
		int result = 0;
		for (int i=0; i<6; i++) {
			result+=n/money[i];
			n%=money[i];
		}
		System.out.println(result);
	}
}