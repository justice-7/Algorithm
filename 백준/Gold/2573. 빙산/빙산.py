import sys
input = sys.stdin.readline
from collections import deque
dx,dy = [1,-1,0,0],[0,0,1,-1]
def bfs(r,c):
    q = deque([(r,c)])
    visit[r][c] = 1
    while q:
        now = q.popleft()
        for i in range(4):
            nx = now[0]+dx[i]
            ny = now[1]+dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if visit[nx][ny]==0 and matrix[nx][ny]!=0:
                visit[nx][ny] = 1
                q.append((nx,ny))

n,m = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]
ice = []
for i in range(n):
    for j in range(m):
        if matrix[i][j] > 0:
            ice.append((i,j))

result = 0
while True:
    result +=1
    melt = [[0]*m for _ in range(n)]
    for i,j in ice:
        for k in range(4):
            nx = i+dx[k]
            ny = j+dy[k]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if matrix[nx][ny]==0:
                melt[i][j] += 1
    newIce = []
    for i,j in ice:
        matrix[i][j] = max(0,matrix[i][j]-melt[i][j])
        if matrix[i][j]>0:
            newIce.append((i,j))
    ice = newIce

    visit = [[0]*m for _ in range(n)]
    splitCnt = 0
    for r,c in ice:
        if matrix[r][c] !=0 and visit[r][c]==0:
            splitCnt+=1
            bfs(r,c)
    if splitCnt==0:
        print(0)
        break
    elif splitCnt>=2:
        print(result)
        break