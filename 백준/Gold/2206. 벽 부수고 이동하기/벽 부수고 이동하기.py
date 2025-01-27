import sys
from collections import deque
input = sys.stdin.readline

def bfs(x,y):
    q = deque()
    q.append((x,y,0,1))
    visit = [[[0]*2 for _ in range(m)] for _ in range(n)]
    visit[x][y][0] = 1
    while q:
        nowX,nowY, bu, cnt = q.popleft()
        if nowX==n-1 and nowY==m-1:
            return cnt
        for i in range(4):
            nx = nowX+dx[i]
            ny = nowY+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=m or visit[nx][ny][bu]==1:
                continue
            if matrix[nx][ny]==0:
                visit[nx][ny][bu] = 1
                q.append((nx,ny,bu,cnt+1))
            elif matrix[nx][ny]==1 and bu==0:
                visit[nx][ny][1] = 1
                q.append((nx,ny,1,cnt+1))
    return -1

dx,dy = [1,-1,0,0],[0,0,1,-1]
n,m = map(int, input().split())
matrix = [list(map(int,input().rstrip())) for _ in range(n)]

print(bfs(0,0))