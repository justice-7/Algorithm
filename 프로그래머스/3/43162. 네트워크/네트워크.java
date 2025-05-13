import java.util.*;
class Solution {
    static int[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new int[n];
        for (int i=0; i<n; i++){
            if (visit[i]==0){
                dfs(i,n, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int x, int n, int[][] computers){
        visit[x] = 1;
        for (int y=0; y<n; y++){
            if (computers[x][y]==1 && visit[y]==0){
                dfs(y,n,computers);
            }
            
        }
    }
}