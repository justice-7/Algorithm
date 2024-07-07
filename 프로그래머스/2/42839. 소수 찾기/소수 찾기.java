import java.util.*;

class Solution {
    static int[] a, visit;
    static int n;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        n = numbers.length();
        a = new int[n];
        visit = new int[n];
        for (int i=0; i<n; i++){
            a[i] = numbers.charAt(i)-'0';
        }
        for (int j=1; j<=n; j++){
            per(0,j, new String[j]);
        }
        int answer = 0;
        for (int number:set){
            if (isPrime(number)){
                ++answer;
            }
        }
        return answer;
    }
    
    public void per(int cnt, int r, String[] result){
        if (cnt == r){
            int num = Integer.parseInt(String.join("", result));
            set.add(num);
        
            return;
        }
        for (int i=0; i<n; i++){
            if (visit[i]==0){
                visit[i]=1;
                result[cnt] = ""+a[i];
                per(cnt+1, r, result);
                visit[i]=0;
            }
        }
        
    }
    
    public boolean isPrime(int num){
        int[] prime = new int[num+1];
        prime[0]=1; // 0은 소수X
        if (num>0)
            prime[1]=1; // 1은 소수X
        for (int i=2; i<=Math.sqrt(num); i++){
            if (prime[i]==1)
                continue;
            for (int j=i+i; j<=num; j+=i) {
                prime[j]=1;
            }
        }
        return prime[num]==1?false:true;
    }
}