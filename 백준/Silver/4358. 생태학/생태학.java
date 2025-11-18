import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	public static void main(String[] args) throws IOException {
		float cnt = 0f;
		String input = "";
		while ((input = br.readLine()) != null) {
			hm.put(input, hm.getOrDefault(input, 0)+1);
			cnt++;
		}
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(hm.entrySet());
		list.sort(Map.Entry.comparingByKey());

		for (Map.Entry<String, Integer> m: list) {
			System.out.printf("%s %.4f\n", m.getKey(),m.getValue()/cnt*100);
		}
	}
}