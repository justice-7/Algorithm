import heapq
dr,dc = [1,-1,0,0],[0,0,1,-1]
m,n = map(int, input().split())
a = [list(map(int, input())) for _ in range(n)]
INF = float('inf')
dist = [[INF]*m for _ in range(n)]

def dijk(r,c):
    q = []
    heapq.heappush(q,(0,r,c))
    dist[r][c] = 0
    while q:
        cost, r,c = heapq.heappop(q)
        if dist[r][c] < cost:
            continue
        for i in range(4):
            nr = r+dr[i]
            nc = c+dc[i]
            if nr >= n or nr < 0 or nc >=m or nc<0:
                continue
            if dist[nr][nc] > cost + a[nr][nc]:
                    dist[nr][nc] = cost + a[nr][nc]
                    heapq.heappush(q,(dist[nr][nc],nr,nc))
                
dijk(0,0)
print(dist[n-1][m-1])