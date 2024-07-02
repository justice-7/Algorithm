import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] s = br.readLine().replace("+"," + ").replace("-", " - ").split(" ");
		Deque<Integer> d = new ArrayDeque<Integer>();
		int i=0;
		while (i<s.length) {
			if (s[i].equals("+")) {
				int tmp = d.removeLast();
				d.add(tmp+Integer.parseInt(s[++i]));
			}
			else if (s[i].equals("-")) {
				d.add(Integer.parseInt(s[++i]));
				
			}
			else {
				d.add(Integer.parseInt(s[i]));
			}
			++i;
		}
		int result = d.poll();
		while (!d.isEmpty()) {
			result-= d.poll();
		}
		System.out.println(result);
	}

}