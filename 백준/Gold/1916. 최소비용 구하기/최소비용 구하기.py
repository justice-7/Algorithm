import sys, heapq
input = sys.stdin.readline

n = int(input())
m = int(input())
inf = float('inf')
g = [[] for _ in range(n+1)]
for i in range(m):
    u,v,w = map(int, input().split())
    g[u].append((v,w))
s,e = map(int, input().split())
dist = [inf]*(n+1)
dist[s] = 0
pq =[]
heapq.heappush(pq,(0,s))
while pq:
    nowW,nowV = heapq.heappop(pq)
    if nowV == e:
        print(dist[e])
        break
    if dist[nowV] < nowW:
        continue
    for nextV,nextW in g[nowV]:
        if dist[nextV] > dist[nowV]+nextW:
            dist[nextV] = dist[nowV]+nextW
            heapq.heappush(pq, (dist[nextV],nextV))