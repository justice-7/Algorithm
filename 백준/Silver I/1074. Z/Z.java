import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,r,c, result, ok=0;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int num = (int) Math.pow(2, n);
		dq(0,0, num/2);
	}
	public static void dq(int x, int y, int n) {
		if (r==x && c==y) {
			System.out.println(result);
			return;
		}
		if (n==0) {
			result++;
			return;
		}
		if (x+n<=r && y+n<=c) {
			result+= n*n*3;
			dq(x+n,y+n, n/2);
		}
		else if (x+n<=r && y<=c) {
			result += n*n*2;
			dq(x+n, y, n/2);
		}
		else if (x<=r &&y+n<=c) {
			result += n*n;
			dq(x, y+n, n/2);
		}
		else 
			dq(x,y, n/2);
	}
}