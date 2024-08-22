import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m, f,a,b;
	static int[] parent;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for (int j=0; j<=n; j++) {
			parent[j]=j;
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			f = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (f==0) {
				union(a,b);
			}
			else if (f==1){
				if (find(a)==find(b))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
	
	public static int find(int x) {
		if (parent[x]==x)
			return x;
		return parent[x]=find(parent[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x<y)
			parent[y]= x;
		else 
			parent[x] = y;
	}

}