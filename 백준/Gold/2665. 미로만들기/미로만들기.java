import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[][] ar, visit;
	static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		ar = new int[n][n];
		for (int i=0; i<n; i++) {
			String s = br.readLine();
			for (int j=0; j<n; j++) {
				ar[i][j] = s.charAt(j)-'0';
			}
		}
		bfs(0,0);	
	}
	public static void bfs(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt));
		visit = new int[n][n];
		pq.add(new Node(x,y,0));
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.x==n-1 &&now.y==n-1) {
				System.out.println(now.cnt);
				return;
			}
			if (visit[now.x][now.y]!=0)
				continue;
			visit[now.x][now.y] = 1;
			for (int i=0; i<4; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if (nx<0 || nx>=n || ny<0 || ny>=n)
					continue;
				if (ar[nx][ny]==1) {
					pq.add(new Node(nx,ny,now.cnt));
				}
				else {
					pq.add(new Node(nx,ny, now.cnt+1));
				}
			}
		}
	}
	
	public static class Node{
		int x;
		int y;
		int cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

}