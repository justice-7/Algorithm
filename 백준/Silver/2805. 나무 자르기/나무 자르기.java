import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static long[] root;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		root = new long[n];
		st = new StringTokenizer(br.readLine());
		long end=0;
		for (int i=0; i<n; i++) {
			root[i] = Long.parseLong(st.nextToken());
			end = Math.max(end, root[i]);
		}
		long start = 0;
		while (start<=end) {
			long mid = start+(end-start)/2;
			long hap = 0;
			for(int j=0; j<n; j++) {
				hap += Math.max(root[j]-mid, 0);
			}
			if (hap>=m) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		System.out.println(end);
	}

}