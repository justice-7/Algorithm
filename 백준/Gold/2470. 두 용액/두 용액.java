import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[] ar;
	public static void main(String[] args) throws Exception{
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		ar = new int[n];
 		for (int i=0; i<n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ar);
		int left = 0;
		int right = n-1;
		int rl = 0; 
		int rr = 0;
		int zero = Integer.MAX_VALUE;
		while(left<right) {
			int tmp = ar[left]+ar[right];
			if (tmp == 0) {
				rl = left;
				rr = right;
				break;
			}
			else if (tmp<0){
				if (zero>Math.abs(tmp)) {
					zero = Math.abs(tmp);
					rl = left;
					rr = right;
				}
				left+=1;
			}
			else {
				if (zero>Math.abs(tmp)) {
					zero = Math.abs(tmp);
					rl = left;
					rr = right;
				}
				right-=1;
			}
		}
		System.out.println(ar[rl]+" "+ar[rr]);
	}

}