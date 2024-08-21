import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] bucket, result;
	static int[] sender = {0,0,1,1,2,2}, receiver= {1,2,0,2,0,1};
	static int[][] visit = new int[201][201];
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		bucket = new int [3];
		for (int i=0; i<3; i++) {
			bucket[i] = Integer.parseInt(st.nextToken());
		}
		result = new int[201];
		bfs();
		for (int j=0; j<=200; j++) {
			if (result[j]==1)
				sb.append(j+" ");
		}
		System.out.println(sb);
		
	}
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0));
		visit[0][0]=1;
		while (!q.isEmpty()) {
			Node now = q.poll();
			if (now.a==0) {
				result[bucket[2]-now.b]=1;
			}
			for(int i=0; i<6; i++) {
				int[] next = {now.a, now.b, bucket[2]-now.a-now.b};
				next[receiver[i]] += next[sender[i]];
				next[sender[i]] = 0;
				if (next[receiver[i]] > bucket[receiver[i]]) {
					next[sender[i]] = next[receiver[i]] - bucket[receiver[i]];
					next[receiver[i]] = bucket[receiver[i]];	
				}
				if (visit[next[0]][next[1]]==0) {
					visit[next[0]][next[1]] = 1;
					q.add(new Node(next[0], next[1]));
				}

			}
		}
	}

	public static class Node{
		int a;
		int b;
		public Node(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
	}

}