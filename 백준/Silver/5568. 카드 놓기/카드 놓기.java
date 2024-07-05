import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n,k;
	static int[] card, visit;
	static Set<String> result = new HashSet<String>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		card = new int[n];
		visit = new int[n];
		for (int i=0; i<n; i++) {
			card[i] = Integer.parseInt(br.readLine());
		}
		per(0,new String[k]);
		System.out.println(result.size());
	}

	// 순열 nPk
	public static void per(int cnt, String[] a) {
		if (cnt == k) {
			result.add(String.join("", a));
			return;
		}
		for (int i=0; i<n; i++) {
			if (visit[i]==0) {
				visit[i]=1;
				a[cnt]=""+card[i];
				per(cnt+1,a);
				visit[i]=0;
			}			
		}
	}

}