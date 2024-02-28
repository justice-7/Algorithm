
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        if(n==1){
            System.out.println(0);
            System.exit(0);
        }
        if(n==2){
            System.out.println(1);
            System.exit(0);
        }


        int[] dp=new int[n+1];

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[1]=0;
        dp[2]=1;
        dp[3]=1;

        for(int i=4; i<n+1; i++){
            if(i%3==0){
                dp[i]=Math.min(dp[i/3]+1,dp[i]);
            }
            if(i%2==0){
                dp[i]=Math.min(dp[i/2]+1,dp[i]);
            }
            dp[i]=Math.min(dp[i],dp[i-1]+1);

        }
//        System.out.println(Arrays.toString(dp));

        System.out.println(dp[n]);


    }
}
