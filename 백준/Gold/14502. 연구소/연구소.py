dx, dy =[0,0,1,-1],[1,-1,0,0]
visit = []

def bfs(x,y):
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if (nx<0 or nx>=n or ny<0 or ny>=m):
            continue
        if (visit[nx][ny]==0 and matrix[nx][ny]==0):
            visit[nx][ny]=1
            bfs(nx,ny)

def safeCnt():
    global visit
    visit=[[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if matrix[i][j]==1:
                visit[i][j]=1
            elif visit[i][j]==0 and matrix[i][j]==2:
                visit[i][j]=1
                bfs(i,j)
    noSafe = 0
    for i in range(n):
        noSafe+=sum(visit[i])
    return n*m-noSafe

def sol(x,y,cnt):
    global result
    if cnt==3:
        result = max(result, safeCnt())
        return
    for i in range(x,n):
        for j in range(0,m):
            if matrix[i][j]==0:
                matrix[i][j]=1
                sol(i,j,cnt+1)
                matrix[i][j]=0
                

n,m = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]
result = 0
sol(0,0,0)
print(result)