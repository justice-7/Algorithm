import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new  StringBuilder();
	static int n;
	static int[] prime = {1, 2, 3, 5, 7, 9};
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		comb(0, 0);
		System.out.println(sb);
	}

	public static void comb(int cnt, int num) {
		if(cnt == n) {
			sb.append(num+"\n");
			return;
		}
		else {
			for (int i=0; i<prime.length; i++) {
				int newNum = num*10 + prime[i];
				if (isPrime(newNum)) {
					comb(cnt+1, newNum);
				}
			}
		}
	}
	
	public static boolean isPrime(int num) {
		if (num==2)
			return true;
		else if (num%2==0 || num==1)
			return false;
		else {
			for (int j=3; j*j<=num; j+=2) {
				if (num%j==0)
					return false;
			}
		}
		return true;
	}
}