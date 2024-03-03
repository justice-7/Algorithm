import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int v,e;
	static final int INF = Integer.MAX_VALUE;
	static int[] minDist, visit;
	static List<Node>[] graph;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()); 
		v = Integer.parseInt(st.nextToken()); // 정점 개수
		e = Integer.parseInt(st.nextToken()); // 간선 개수
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 시작점 인덱스
		
		// 인접 리스트 생성
		graph = new ArrayList[v+1];
		for (int i=1; i<=v; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b,w));
		}
		
		minDist = new int [v+1];
		Arrays.fill(minDist, INF);
		visit = new int[v+1];
		dijkstra(start);
		for (int j=1; j<=v; j++) 
			System.out.println(minDist[j]==INF ? "INF":minDist[j]);
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		minDist[start] = 0; // 출발지의 가중치는 0
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (visit[now.v]==1)
				continue;
			visit[now.v] = 1;
			for (int i=0 ;i<graph[now.v].size(); i++) {
				Node next = graph[now.v].get(i);
				// 기존 최소 비용과 선택된 경유지를 거쳐서 가는 비용을 비교해서 업데이트
				if (minDist[next.v] > minDist[now.v]+next.w) {
					minDist[next.v] = minDist[now.v]+next.w;
					pq.offer(new Node(next.v, minDist[next.v]));
				}
			}
		}
	}
	
	public static class Node implements Comparable<Node>{
		int v;
		int w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
}