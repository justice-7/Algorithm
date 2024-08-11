import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] bucket;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		bucket = new int[n+1];
		for (int k=1; k<=n; k++) {
			bucket[k]=k;
		}
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			swap(a,b);
		}
		for (int j=1; j<=n; j++) {
			sb.append(bucket[j]+" ");
		}
		System.out.println(sb);
	}
	public static void swap(int a, int b) {
		while(a<b) {
			int tmp = bucket[a];
			bucket[a] = bucket[b];
			bucket[b] = tmp;
			a++;
			b--;
		}
	}
    
}