import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		int t = Integer.parseInt(br.readLine());
		int[] result = new int[12];
		result[1]=1;
		result[2]=2;
		result[3]=4;
		for (int i=4; i<=11; i++) {
			result[i]=result[i-3]+result[i-2]+result[i-1];
		}
		for (int j=0; j<t; j++) {
			int a = Integer.parseInt(br.readLine());
			sb.append(result[a]+"\n");
		}
		System.out.println(sb);
	}

}