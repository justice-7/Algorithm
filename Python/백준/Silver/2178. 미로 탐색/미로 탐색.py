from collections import deque
def bfs(sx,sy):
    q = deque()
    q.append((sx,sy,1))
    visit = [[0]*m for _ in range(n)]
    visit[sx][sy] = 1
    while q:
        x,y,cnt = q.popleft()
        if x==n-1 and y==m-1:
            return cnt
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            if ar[nx][ny]==1 and visit[nx][ny]==0:
                visit[nx][ny]=1
                q.append((nx,ny,cnt+1))

n,m = map(int, input().split())
ar = [list(map(int, input())) for _ in range(n)]
dx,dy=[1,-1,0,0],[0,0,1,-1]
print(bfs(0,0))