import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, result =0;
	static Stack<Work> list = new Stack<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int possible = Integer.parseInt(st.nextToken());
			if (possible==1) {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				if (time-1==0)
					result+=score;
				else {
					list.push(new Work(score,time-1));
				}
			}
			else {
				if (!list.isEmpty()) {
					if (list.peek().time-1==0) {
						result+= list.pop().score;
					}
					else {
						list.peek().time--;
					}
				}
			}			
		}
		System.out.println(result);
	}

	public static class Work {
		int score;
		int time;
		public Work(int score, int time) {
			super();
			this.score = score;
			this.time = time;
		}
	}
}