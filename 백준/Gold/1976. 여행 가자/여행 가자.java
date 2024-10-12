import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int[] city,parent;
	public static void main(String[] args)throws Exception {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		parent = new int[n];
		for (int i=0; i<n; i++) {
			parent[i] = i;
		}
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				if (Integer.parseInt(st.nextToken())==1)
						union(i,j);
			}
		}
		city = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int k=0; k<m; k++) {
			city[k] = Integer.parseInt(st.nextToken())-1;
		}
		int temp = city[0];
		int yes = 1;
		for (int k=1; k<m; k++) {
			if (find(temp)!=find(city[k])) {
				yes = 0;
				break;
			}
			temp=city[k];
		}
		System.out.println(yes==1?"YES":"NO");
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a<b) {
			parent[b] = a;
		}
		else 
			parent[a] = b;
	}
	public static int find(int x) {
		if (parent[x]==x)
			return x;
		else
			return parent[x]=find(parent[x]);
	}

}