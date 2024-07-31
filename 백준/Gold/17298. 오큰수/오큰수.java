import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		int[] result = new int[n];
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<Integer>();
		for (int j=n-1; j>=0; j--) {
			while (!stack.isEmpty() && stack.peek()<=a[j]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result[j]=-1;
			}
			else {
				result[j]=stack.peek();
			}
			stack.add(a[j]);
		}
		for (int k=0; k<n; k++) {
			sb.append(result[k]+" ");
		}
		System.out.println(sb);
	}
}