import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder pre = new StringBuilder();
	static StringBuilder in = new StringBuilder();
	static StringBuilder post = new StringBuilder();
	static int n;
	static int[][] g;
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		g = new int [n][2];
		for (int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			int root = s[0].charAt(0)-65;
			for (int j=0; j<2; j++) {
				int al = s[j+1].charAt(0)-65;
				if (al=='.'-65)
					g[root][j]=-1;
				else
					g[root][j]=al;
			}
		}
		order(0);
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	}
	
	public static void order(int a) {
		if (a==-1)
			return;
		pre.append((char)(a+65));
		order(g[a][0]);
		in.append((char)(a+65));
		order(g[a][1]);
		post.append((char)(a+65));
	}
}