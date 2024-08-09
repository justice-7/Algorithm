import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		Set<Integer> set = new HashSet<Integer>();
		for (int i=0; i<10; i++) {
			int n = Integer.parseInt(br.readLine());
			set.add(n%42);
		}
		System.out.println(set.size());
	}

}