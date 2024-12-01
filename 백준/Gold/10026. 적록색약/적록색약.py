from collections import deque
dx,dy = [1,-1,0,0],[0,0,1,-1]
def bfs(x,y):
    q = deque()
    q.append([x,y])
    while(len(q)!=0):
        now = q.popleft()
        for i in range(4):
            nx = now[0]+dx[i]
            ny = now[1]+dy[i]
            if (nx<0 or nx>=n or ny<0 or ny>=n):
                continue
            if (visit[nx][ny]==0 and matrix[nx][ny]==matrix[x][y]):
                visit[nx][ny]=1
                q.append([nx,ny,matrix[nx][ny]])

def bfs2(x,y,c):
    q = deque()
    q.append([x,y])
    while(len(q)!=0):
        now = q.popleft()
        for i in range(4):
            nx = now[0]+dx[i]
            ny = now[1]+dy[i]
            if (nx<0 or nx>=n or ny<0 or ny>=n or visit[nx][ny]==1):
                continue
            if (c=='R' or c=='G') and (matrix[nx][ny]=='R' or matrix[nx][ny]=='G'):
                visit[nx][ny]=1
                q.append([nx,ny,matrix[nx][ny]])
            elif (matrix[nx][ny]==c):
                visit[nx][ny]=1
                q.append([nx,ny,matrix[nx][ny]])

n = int(input())
matrix = [list(input()) for _ in range(n)]
visit=[[0]*n for _ in range(n)]
cnt1,cnt2=0,0
for i in range(n):
    for j in range(n):
        if visit[i][j]==0:
            cnt1+=1
            visit[i][j]=1
            bfs(i,j)

visit=[[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if visit[i][j]==0:
            cnt2+=1
            visit[i][j]=1
            bfs2(i,j,matrix[i][j])

print(cnt1, cnt2)