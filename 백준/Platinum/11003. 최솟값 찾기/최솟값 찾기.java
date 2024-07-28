import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,l;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Node> d = new LinkedList<>();
		for (int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			while(!d.isEmpty() && d.getLast().num>a) {
				d.removeLast();
			}
			while(!d.isEmpty() && d.getFirst().index<=i-l) {
				d.removeFirst();
			}
			d.addLast(new Node(i,a));
			sb.append(d.getFirst().num+" ");
		}
		System.out.println(sb);
	}
	public static class Node{
		int index;
		int num;
		public Node(int index, int num) {
			this.index = index;
			this.num = num;
		}
	}
}