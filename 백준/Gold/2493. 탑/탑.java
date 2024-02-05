import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		Deque<int[]> dq = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		boolean zero = true;
		for (int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(!dq.isEmpty() && dq.peek()[0]<num) {
				dq.pop();
			}
			if (dq.isEmpty())
				sb.append("0 ");
			else {
				sb.append(dq.peek()[1]+" ");
				zero = false;
			}
			dq.push(new int[] {num,i+1});
		}
		if (zero)
			System.out.println("0");
		else
			System.out.println(sb);
	}
}