import sys, heapq
input = sys.stdin.readline

def dijk(start):
    dist[start] = float('inf')
    pq = []
    heapq.heappush(pq, (-dist[start],start))
    while pq:
        nowW,nowV = heapq.heappop(pq)
        nowW = -nowW
        if dist[nowV] > nowW:
            continue
        for nextV,nextW in g[nowV]:
            if dist[nextV] < min(nowW, nextW):
                dist[nextV] = min(nowW, nextW)
                heapq.heappush(pq, (-dist[nextV],nextV))

n,m = map(int, input().split())
g = [[] for _ in range(n+1)]
for i in range(m):
    a,b,c = map(int, input().split())
    g[a].append((b,c))
    g[b].append((a,c))

s1,s2 = map(int, input().split())

dist = [0]*(n+1)
dijk(s1)
print(dist[s2])