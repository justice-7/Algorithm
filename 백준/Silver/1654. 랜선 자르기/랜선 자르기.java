import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int k,n;
	static int[] ar;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		ar = new int[k];
		int maxLen = 0;
		for (int i=0; i<k; i++) {
			ar[i] = Integer.parseInt(br.readLine());
			maxLen = Math.max(ar[i], maxLen);
		}
		long start = 1;
		long end = maxLen;
		while(start<=end) {
			long mid = (start+end)/2;
			int cnt = 0;
			for (int j=0; j<k ;j++) {
				cnt += ar[j]/mid;
			}
			if (cnt>=n) {
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		System.out.println(end);
	}

}