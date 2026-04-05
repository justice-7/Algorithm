from collections import deque
dx,dy = [1,-1,0,0],[0,0,1,-1]
def bfs(r,c):
    q = deque()
    q.append((r,c,0))
    visit[r][c] = 0
    while q:
        now = q.popleft()
        for i in range(4):
            nx = now[0]+dx[i]
            ny = now[1]+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            if g[nx][ny]==1 and visit[nx][ny]==-1:
                visit[nx][ny] = now[2]+1
                q.append((nx,ny,visit[nx][ny]))

n,m = map(int,input().split())
g = [list(map(int,input().split())) for _ in range(n)]
visit = [[-1]*m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if g[i][j]==0:
            visit[i][j] = 0
        elif g[i][j] == 2:
            bfs(i,j)

print('\n'.join([' '.join(map(str,i)) for i in visit]))