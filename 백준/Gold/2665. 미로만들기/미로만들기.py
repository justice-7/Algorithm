# 다익스트라
import heapq

def dijk(r,c):
    pq =[]
    heapq.heappush(pq,(0,r,c))
    dist[r][c] = 0
    while pq:
        nowW,nowR,nowC = heapq.heappop(pq)
        if dist[nowR][nowC] < nowW:
            continue
        for i in range(4):
            nx = nowR + dx[i]
            ny = nowC + dy[i]
            if nx<0 or ny<0 or nx>=n or ny>=n:
                continue
            nextW = nowW+(1 if matrix[nx][ny]==0 else 0)
            if dist[nx][ny] > nextW:
                dist[nx][ny] = nextW
                heapq.heappush(pq,(nextW,nx,ny))

dx,dy = [0,0,1,-1],[1,-1,0,0]
n = int(input())
matrix = [list(map(int,input())) for _ in range(n)]
black = set()
for i in range(n):
    for j in range(n):
        if matrix[i][j] == 0:
            black.add((i, j))
dist = [[float('inf')] * n for _ in range(n)]
dijk(0,0)
print(dist[n-1][n-1])