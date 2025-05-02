from collections import deque
dx,dy = [1,0,0,-1],[0,-1,1,0]
path = "dlru"

def solution(n, m, x, y, r, c, k):
    answer = []
    return bfs(n,m,x-1,y-1,r-1,c-1,k, answer)

def bfs(n,m,x,y,r,c,k, answer):
    visit = [[[0]*(k+1) for _ in range(m)] for _ in range(n)]
    visit[x][y][0] = 1
    q = deque([(x,y,0,"")])
    while q:
        x,y,cnt,p = q.popleft()
        if cnt == k:
            if x==r and y==c:
                return p
            continue
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx<0 or nx>=n or ny<0 or ny>=m:
                continue
            if visit[nx][ny][cnt+1]==0:
                visit[nx][ny][cnt+1]=1
                q.append((nx,ny,cnt+1, p+path[i]))
    return "impossible"