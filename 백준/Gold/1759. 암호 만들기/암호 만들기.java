import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int l,c;
	static char[] al;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		al = new char[c];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<c; i++) {
			al[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(al);
		sol(0,0, new char[l]);
		System.out.println(sb);
	}

	public static void sol(int cnt, int start, char[] a) {
		if (cnt == l) {
			if (possible(a)) {
				for (int j=0; j<l; j++) 
					sb.append(a[j]);
				sb.append("\n");
			}
			return;
		}
		for (int k=start; k<c; k++) {
			a[cnt] = al[k]; 
			sol(cnt+1, k+1, a);
		}
	}

	public static boolean possible(char[] ar) {
		int aeiou = 0;
		for (char c: ar) {
			if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
				aeiou++;
		}
		if (aeiou>=1 && l-aeiou>=2)
			return true;
		else
			return false;
	}
}