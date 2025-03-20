import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<n+1; i++){
            ar[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ar);
        for (int j=1; j<=n; j++){
            ar[j] = ar[j-1]+ar[j];
        }
        int sum = 0;
        for (int k=1; k<=n; k++){
            sum+=ar[k];
        }
        System.out.println(sum);
    }
}