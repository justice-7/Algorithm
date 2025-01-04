from collections import deque
dx,dy = [1,-1,0,0], [0,0,1,-1]

def bfs():
    q = deque()
    for i in range(n):
        for j in range(m):
            if matrix[i][j]==1:
                q.append((i,j))
    cnt = -1
    while q:
        size = len(q)
        cnt+=1
        for i in range(size):
            now = q.popleft()
            for k in range(4):
                nx = now[0]+dx[k]
                ny = now[1]+dy[k]
                if nx<0 or nx>=n or ny<0 or ny>=m:
                    continue
                if matrix[nx][ny]==0:
                    matrix[nx][ny]=1
                    q.append((nx,ny))
    for i in range(n):
        for j in range(m):
            if matrix[i][j]==0:
                return -1
    return cnt

m,n = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range (n)]
result = 0
print(bfs())