from collections import deque
dr,dc = [1,-1,0,0],[0,0,1,-1]
m,n = map(int, input().split())
a = [list(map(int, input().strip())) for _ in range(n)]
INF = float('inf')
visit = [[INF]*m for _ in range(n)]

def bfs(r,c):
    q = deque([(r,c)])
    visit[r][c] = 0
    while q:
        r,c = q.popleft()
        for i in range(4):
            nr = r+dr[i]
            nc = c+dc[i]
            if nr >= n or nr < 0 or nc >=m or nc<0:
                continue
            if a[nr][nc]==1:
                if visit[nr][nc] > visit[r][c]+1:
                    visit[nr][nc] = visit[r][c]+1
                    q.append((nr,nc))
            elif visit[nr][nc] > visit[r][c]:
                visit[nr][nc] = visit[r][c]
                q.appendleft((nr,nc))

bfs(0,0)
print(visit[n-1][m-1])