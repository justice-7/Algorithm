import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	public static void main(String[] args) throws Exception{
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Integer> minus = new ArrayList<>();
		List<Integer> plus = new ArrayList<>();
 		for (int i=0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a>0)
				plus.add(a);
			else 
				minus.add(a);
		}
		Collections.sort(plus);
		Collections.sort(minus);
		int mi = minus.size()-1;
		int pl = 0;
		int left = 0;
		int right = 0;
		int zero = Integer.MAX_VALUE;
		while(minus.size()>0 && plus.size()>0 && mi>=0 && pl<plus.size()) {
			int tmp = minus.get(mi)+plus.get(pl);
			if (tmp == 0) {
				left = minus.get(mi);
				right = plus.get(pl);
				break;
			}
			else if (tmp<0){
				if (zero>Math.abs(tmp)) {
					zero = Math.abs(tmp);
					left = minus.get(mi);
					right = plus.get(pl);
				}
				pl+=1;
			}
			else {
				if (zero>Math.abs(tmp)) {
					zero = Math.abs(tmp);
					left = minus.get(mi);
					right = plus.get(pl);
				}
				mi-=1;
			}
		}
	
		if (plus.size()>=2 && zero>plus.get(0)+plus.get(1)) {
			zero = plus.get(0)+plus.get(1);
			left = plus.get(0);
			right = plus.get(1);
		}
		if (minus.size()>=2 && zero>Math.abs(minus.get(minus.size()-1)+minus.get(minus.size()-2))) {
			zero = minus.get(minus.size()-1)+minus.get(minus.size()-2);
			left = minus.get(minus.size()-2);
			right = minus.get(minus.size()-1);
		}
		System.out.println(left+" "+right);
	}

}