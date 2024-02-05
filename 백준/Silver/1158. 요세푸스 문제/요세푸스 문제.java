import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Deque<Integer> dq = new LinkedList<>();
		for (int i=1; i<=n; i++) {
			dq.add(i);
		}
		int ind = 0;
		sb.append("<");
		while (!dq.isEmpty()) {
			if (++ind%k==0)
				sb.append(dq.poll()+", ");
			else 
				dq.offer(dq.poll());
		}
		sb.delete(sb.length()-2, sb.length()).append(">");
		System.out.println(sb);
	}
}