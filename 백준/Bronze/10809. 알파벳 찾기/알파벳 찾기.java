import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		String s = br.readLine();
		int[] result = new int[26];
		for (int i=0; i<26; i++) {
			result[i]=-1;
		}
		for (int j=0; j<s.length(); j++) {
			if (result[s.charAt(j)-'a']==-1)
			result[s.charAt(j)-'a']=j;
		}
		for (int k=0; k<26; k++) {
			sb.append(result[k]+" ");
		}
		System.out.println(sb);
	}
}