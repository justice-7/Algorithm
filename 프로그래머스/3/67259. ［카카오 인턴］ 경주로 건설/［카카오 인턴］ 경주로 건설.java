import java.util.*;

class Node{
    int x, y, cost, dir;
    public Node(int x, int y, int cost, int dir){
        this.x=x;
        this.y=y;
        this.cost=cost;
        this.dir=dir;
    }
}
class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int solution(int[][] board) {

        return dijk(0,0, board);
    }
    
    public int dijk(int r, int c, int[][] board){
        int n = board.length;
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a,b) -> a.cost-b.cost
        );
        pq.offer(new Node(r,c,0,-1));
        int[][][] w = new int[n][n][4];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                Arrays.fill(w[i][j], Integer.MAX_VALUE);
            }
        }
        while (!pq.isEmpty()){
            Node now = pq.poll();
            if (now.x==n-1 && now.y==n-1){
                return now.cost;
            }
            if (now.dir!=-1 && now.cost> w[now.x][now.y][now.dir])
                continue;
            for(int i=0; i<4; i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];
                if (nx<0 || nx>=n || ny<0 || ny>=n)
                    continue;
                int nextW = now.cost;
                if (now.dir==-1 || now.dir==i)
                    nextW+=100;
                else
                    nextW+=600;
                if (board[nx][ny]==0 && w[nx][ny][i]>nextW){
                    w[nx][ny][i] = nextW;
                    pq.offer(new Node(nx,ny,nextW,i));
                }
            }    
        }
        return -1;
    }
}