import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[][] ar = new char[n][8];
		int[] num = new int[26];
		for (int i =0; i<n; i++) {
			String s = br.readLine();
			for (int j=0; j<s.length(); j++) {
				ar[i][8-s.length()+j] = s.charAt(j);
				map.put(ar[i][8-s.length()+j], map.getOrDefault(ar[i][8-s.length()+j], 0)+  (int)Math.pow(10,s.length()-1-j));
			}
		}
		
		List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((o1, o2) -> map.get(o2.getKey()).compareTo(map.get(o1.getKey())));
//		System.out.println(list);
		int ind = 9;
		for (Map.Entry<Character, Integer> al: list) {
			num[al.getKey()-'A']= ind--;
		}
		int result = 0;
		for (int r=0; r<n; r++) {
			int tmp = 0;
			for (int c=0; c<8; c++) {
				if (ar[r][c]!=-'\0') {
					tmp=tmp*10+num[ar[r][c]-'A'];
				}
			}
			result+=tmp;
		}
		System.out.println(result);
	}

}