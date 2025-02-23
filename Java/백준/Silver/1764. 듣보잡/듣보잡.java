import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<String>();
		ArrayList<String> ar = new ArrayList<String>();
		for (int i=0 ;i<n; i++) {
			 set.add(br.readLine());
		}
		for (int j=0; j<m; j++) {
			String s = br.readLine();
			if (set.contains(s)) {
				ar.add(s);
			}	
		}
		Collections.sort(ar);
		System.out.println(ar.size());
		for (int k=0; k<ar.size(); k++) {
			System.out.println(ar.get(k));
		}
	}

}