import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int switchCnt,studentCnt;
	static String[] state;

	public static void main(String[] args) throws NumberFormatException, IOException {
		switchCnt = Integer.parseInt(br.readLine());
		state = br.readLine().split(" ");
		studentCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<studentCnt; i++) {
			String[] student = br.readLine().split(" ");
			int num = Integer.parseInt(student[1])-1;
			int next = num+1;
			if (student[0].equals("1")) {
				while (num<switchCnt) {
					change(num);
					num+=next;
				}
			}
			else {
				change(num);
				int left = num-1;
				int right = num+1;
				while (left>=0 && right<switchCnt) {
					if (state[left].equals(state[right])) {
						change(left--);
						change(right++);
					}
					else
						break;
				}
			}
		}
		for (int j=1; j<=switchCnt; j++) {
			sb.append(state[j-1]+" ");
			if (j%20==0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void change(int index) {
		if (state[index].equals("1")) {
			state[index]="0";
		}
		else {
			state[index]="1";
		}
	}
}