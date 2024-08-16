import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("add")) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			else if (s.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				if (set.contains(x))
					set.remove(x);
			}
			else if (s.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				if (set.contains(x))
					sb.append("1\n");
				else 
					sb.append("0\n");
			}
			else if (s.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				if (set.contains(x))
					set.remove(x);
				else 
					set.add(x);
			}
			else if (s.equals("all")) {
				for(int j=1; j<=20; j++)
					set.add(j);
			}
			else if (s.equals("empty"))
				set.clear();
		}
		System.out.println(sb);
	}

}