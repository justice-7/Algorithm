import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		m = Integer.parseInt(br.readLine());
		int[] result = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int j=0; j<m; j++) {
			int num = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = n-1;
			int left=-1;
			while (start<=end) {
				int mid = start+(end-start)/2;
				if (list.get(mid)== num) {
					left = mid;
					end = mid-1;
				}
				else if (list.get(mid) < num) {
					start = mid+1;
				}
				else {
					end = mid-1;
				}
			}
			start = 0;
			end = n-1;
			int right=-1;
			while (start<=end) {
				int mid = start+(end-start)/2;
				if (list.get(mid) == num) {
					right = mid;
					start = mid+1;
				}
				else if (list.get(mid) < num) {
					start = mid+1;
				}
				else {
					end = mid-1;
				}
			}
			if (left!=-1 & right!=-1)
				result[j]=right-left+1;
		}
		for (int k=0; k<m; k++) {
			sb.append(result[k]+" ");			
		}
		System.out.println(sb);
	}

}