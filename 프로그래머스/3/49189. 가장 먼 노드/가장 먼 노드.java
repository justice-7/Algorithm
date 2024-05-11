import java.util.*;
class Solution {
    static int[] visit;
    static List<List<Integer>> g;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        g = new ArrayList<>();
        for (int i=0; i<=n; i++){
            g.add(new ArrayList<>());
        }
        for(int[] v:edge){
            g.get(v[0]).add(v[1]);
            g.get(v[1]).add(v[0]);
        }
        visit = new int[n+1];
        Arrays.fill(visit,-1);
        bfs();
        int max = 0;
        for (int j:visit)
            max = Math.max(max,j);
        for (int k:visit){
            if (k==max)
                ++answer;
        }
        
        return answer;
    }
    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1]=0;
        while(!q.isEmpty()){
            int now = q.poll();
            for (int i=0; i<g.get(now).size(); i++){
                int next= g.get(now).get(i);
                if (visit[next]==-1){
                    visit[next]=visit[now]+1;
                    q.offer(next);
                }
            }
            
        }
    }
}