import sys
sys.setrecursionlimit(10**6)

def dfs(x,y):
    global w
    w+=1
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if nx<0 or nx>=n or ny<0 or ny>=m:
            continue
        if ar[nx][ny]==1 and visit[nx][ny]==0:
            visit[nx][ny]=1
            dfs(nx,ny)

n,m = map(int, input().split())
ar = [list(map(int, input().split())) for _ in range(n)]
dx,dy = [1,-1,0,0],[0,0,1,-1]
visit = [[0]*m for _ in range(n)]
cnt = 0
ma = 0
for i in range(n):
    for j in range(m):
        if ar[i][j] == 1 and visit[i][j]==0:
            cnt+=1
            w = 0
            visit[i][j]=1
            dfs(i,j)
            ma = max(ma, w)
print(cnt)
print(ma)