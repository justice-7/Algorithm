from collections import deque
dx,dy=[1,-1,0,0],[0,0,1,-1]

def solution(land):
    n, m = len(land), len(land[0])
    answer = [0]*m
    visit = [[0]*m for _ in range(n)]
    for i in range(m):
        for j in range(n):
            if land[j][i]==1 and visit[j][i]==0:
                bfs(j,i, n,m,land,visit,answer)
                
    return max(answer)

def bfs(x, y, n, m, land, visit, answer):
    q = deque()
    visit[x][y] = 1
    q.append((x,y))
    col = {y}
    cnt = 0
    while q:
        now = q.popleft()
        cnt+=1
        for i in range(4):
            nx = now[0]+dx[i]
            ny = now[1]+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            if land[nx][ny]==1 and visit[nx][ny]==0:
                visit[nx][ny]=1
                q.append((nx,ny))
                col.add(ny)
    for i in list(col):
        answer[i]+=cnt