import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int switchCnt = Integer.parseInt(br.readLine());
		String[] state = br.readLine().split(" ");
		int studentCnt = Integer.parseInt(br.readLine());
		for (int i=0; i<studentCnt; i++) {
			String[] student = br.readLine().split(" ");
			int num = Integer.parseInt(student[1]);
			int next = num;
			if (student[0].equals("1")) {
				while (num-1<switchCnt) {
					if (state[num-1].equals("1"))
						state[num-1]="0";
					else
						state[num-1]="1";
					num+=next;
				}
			}
			else {
				num-=1;
				if (state[num].equals("1"))
					state[num]="0";
				else
					state[num]="1";
				int left = num-1;
				int right = num+1;
				while (left>=0 && right<switchCnt) {
					if (state[left].equals(state[right])) {
						if (state[left].equals("1")) {
							state[left]="0";
							state[right]="0";
						}
						else {
							state[left]="1";
							state[right]="1";
						}
						left--;
						right++;
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
}