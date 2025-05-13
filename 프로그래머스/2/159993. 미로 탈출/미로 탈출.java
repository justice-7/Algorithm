import java.util.*;
class Solution {
    static int[] dx={1,-1,0,0}, dy={0,0,1,-1};
    static int[][] visit;
    static int n,m;
    
    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        Node[] nodes = new Node[3];
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (maps[i].charAt(j)=='S'){
                    nodes[0] = new Node(i,j,0);
                }
                else if (maps[i].charAt(j)=='L'){
                    nodes[1] = new Node(i,j,0);
                }
                else if (maps[i].charAt(j)=='E'){
                    nodes[2] = new Node(i,j,0);
                }
            }
        }
        for (int k=1; k<3; k++){
            int result = bfs(nodes[k-1],nodes[k], maps);
            if (result == -1) 
                return -1;
            answer+=result;
        }
        return answer;
    }
    
    public int bfs(Node start, Node end, String[] maps){
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        visit = new int[n][m];
        visit[start.x][start.y]=1;
        while (!q.isEmpty()){
            Node now = q.poll();
            for (int i=0; i<4; i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if (nx<0 || nx>=n || ny<0 || ny>=m)
                    continue;
                if (visit[nx][ny]==0 && maps[nx].charAt(ny)!='X'){
                    if (nx==end.x && ny==end.y){
                        return now.cnt+1;
                    }
                    visit[nx][ny]=1;
                    q.offer(new Node(nx,ny,now.cnt+1));
                }
            }
        }
        return -1;
    }
    
    class Node{
        int x,y,cnt;
        public Node(int x, int y, int cnt){
            this.x = x; 
            this.y = y;
            this.cnt = cnt;
        }
    }
}