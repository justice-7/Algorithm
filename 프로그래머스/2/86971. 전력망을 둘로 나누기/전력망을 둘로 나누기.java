class Solution {
    static int[][] matrix;
    static int[] visit;
    static int cnt;
    public int solution(int n, int[][] wires) {
        int answer = 1000;
        visit = new int[n+1];
        matrix = new int[n+1][n+1];
        for (int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            matrix[a][b]=1;
            matrix[b][a]=1;
        }
        for (int j=0; j<wires.length; j++){
            int a = wires[j][0];
            int b = wires[j][1];
            matrix[a][b]=0;
            matrix[b][a]=0;
            cnt = 0;
            visit[1]=1;
            dfs(1,n);
            if(answer > Math.abs(cnt - (n-cnt))){
                answer = Math.abs(cnt - (n-cnt));    
            }
            matrix[a][b]=1;
            matrix[b][a]=1;
        }
        return answer;
    }
    public static void dfs(int start, int n){
        cnt++;
        for (int i=1; i<n+1; i++){
            if (matrix[start][i]==1 && visit[i]==0) {
                visit[i]=1;
                dfs(i,n);
                visit[i]=0;
            }
        }
    }
}