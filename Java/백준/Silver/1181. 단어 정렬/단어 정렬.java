import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		String[] s = new String[n];
		for (int i=0; i<n; i++) {
			s[i] = br.readLine();
		}
		Set<String> set = new HashSet<>(Arrays.asList(s));
		s = set.toArray(new String[0]);
		Arrays.sort(s, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length()==o2.length()) {
					return o1.compareTo(o2);
				}
				else {
					return o1.length()-o2.length();
				}
			}
			
		});
		
		for (int j=0; j<s.length; j++) {
			System.out.println(s[j]);
		}
		
	}
}