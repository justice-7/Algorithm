import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int ind = 1;
		for (int i=0; i<n; i++) {
			int a = Integer.parseInt(br.readLine());
			while (ind<=n) {
				if (!stack.empty() && stack.peek()==a) {
					sb.append("-\n");
					stack.pop();
					break;
				}
				stack.add(ind++);
				sb.append("+\n");
			}
			if (ind>n) {
				if (stack.peek()==a) {
					stack.pop();
					sb.append("-\n");
				}
				else {
					sb = new StringBuilder("NO");
					break;
				}
			}
		}
		System.out.println(sb);
	}
}