import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,d;
	static int[] dist;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		dist = new int[d+1];
		for(int i=1; i<=d; i++) {
			dist[i] = i;
		}
		List<Node> list = new ArrayList<>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			if (end<=d)
				list.add(new Node(start,end,len));
		}
		for (int j=0; j<=d; j++) {
			if (j>0)
				dist[j] = Math.min(dist[j], dist[j-1]+1);
			for (Node node:list) {
				if (node.start==j) {
					dist[node.end] = Math.min(dist[node.end], dist[node.start]+node.len);
				}
			}
		}
		System.out.println(dist[d]);
	}

	public static class Node{
		int start;
		int end;
		int len;
		public Node(int start, int end, int len) {
			super();
			this.start = start;
			this.end = end;
			this.len = len;
		}
	}
}