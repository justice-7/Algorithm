import java.util.*;
class Solution {
    static List<List<Integer>> a = new ArrayList<>();
    static List<List<Integer>> b = new ArrayList<>();
    static int[] visit, result;
    static int cnt;
    public int solution(int n, int[][] results) {
        int answer = 0;
        for (int i=0; i<=n; i++){
            a.add(new ArrayList<>());
            b.add(new ArrayList<>());            
        }
        for (int[] j:results){
            a.get(j[0]).add(j[1]);
            b.get(j[1]).add(j[0]);
        }
        
        result = new int[n+1];
   
        for (int k=1; k<=n; k++){
            visit= new int[n+1];
            cnt =0;
            dfs(a, k);//a
            result[k]+=cnt;
            
            visit= new int[n+1];
            cnt=0;
            dfs(b, k);//b
            result[k]+=cnt;
        }
        for (int x:result){
            if (x==n+1)
                answer++;
        }
        // System.out.println(Arrays.toString(result));
        return answer;
    }
    
    public static void dfs(List<List<Integer>> ab, int num){
        cnt++;
        visit[num]=1;
        for (int i=0; i<ab.get(num).size(); i++){
            int next = ab.get(num).get(i);
            if (visit[next]==0)
                dfs(ab,next);
        }
    }
}