// 수학적 풀이
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String nToB = Integer.toBinaryString(n);
		int remain = n & ((1<<nToB.length()-1)-1);
		if (remain == 0) {
			System.out.println(n);
		}
		else {
			System.out.println(2*remain);
		}
		input.close();
	}
}