import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int n,s;
	public static int[] ar;
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		ar = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			ar[i] = Integer.parseInt(st.nextToken())+ar[i-1];
		}
		int left = 0;
		int right = 1;
		int result = 1000000;
		while (right<=n) {
			if (ar[right]-ar[left]>=s) {
				result = Math.min(result, right-left);
				left+=1;
			}
			else {
				right+=1;
			}
		}
		System.out.println(result==1000000?0:result);
	}

}