import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n,k;
	public static void main(String[] args) throws Exception {
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		long start = 1;
		long end = k;
		while (start<=end) {
			long mid = start+(end-start)/2;
			long cnt=0;
			for (int i=1; i<=n; i++) {
				cnt+= Math.min(mid/i, n);
			}
			if (cnt < k){
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		System.out.println(start);
	}

}