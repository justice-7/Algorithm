import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static String totalDna = "ACGT";
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String[] dna = new String[n];
		char[] resultDna = new char[m];
		int resultCnt = 0;
		for (int i=0; i<n; i++) {
			dna[i] = br.readLine();
		}
		for (int j=0; j<m; j++) {
			int[] cnt = new int[4];
			for (int k=0; k<n; k++) {
				cnt[totalDna.indexOf(dna[k].charAt(j))]++;
			}
			int maxCnt=0;
			char alph='.';
			for (int i=0; i<4; i++) {
				if (cnt[i]>maxCnt) {
					maxCnt=cnt[i];
					alph = totalDna.charAt(i);
				}
			}
			resultDna[j] = alph;
			resultCnt+=n-maxCnt;
		}
		System.out.println(resultDna);
		System.out.println(resultCnt);
	}
}