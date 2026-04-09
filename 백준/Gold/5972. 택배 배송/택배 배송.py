import heapq

def dijk(x):
    pq = []
    heapq.heappush(pq,(0,x))
    dist[x] = 0
    while pq:
        d,now = heapq.heappop(pq)
        if dist[now] < d:
            continue
        for nextV,nextW in g[now]:
            if dist[nextV] > dist[now]+nextW:
                dist[nextV] = dist[now]+nextW
                heapq.heappush(pq,(dist[nextV],nextV))


n,m = map(int, input().split())
g = [[] for _ in range(n+1)]
for i in range(m):
    a,b,c = map(int, input().split())
    g[a].append((b,c))
    g[b].append((a,c))
dist = [float('inf')]*(n+1)
dijk(1)
print(dist[n])