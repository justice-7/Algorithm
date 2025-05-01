from collections import deque
dx, dy = [1,-1,0,0],[0,0,1,-1]

def solution(maps):
    n,m = len(maps), len(maps[0])
    visit = [[0]*m for _ in range(n)]

    return bfs(0,0,n,m,visit,maps)

def bfs(x,y,n,m,visit,maps):
    q = deque([(x,y,1)])
    visit[x][y]=1
    while q:
        now = q.popleft()
        for i in range(4):
            nx = now[0]+dx[i]
            ny = now[1]+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            if maps[nx][ny]==1 and visit[nx][ny]==0:
                if nx==n-1 and ny==m-1:
                    return now[2]+1
                visit[nx][ny]=1
                q.append((nx,ny,now[2]+1))
    return -1