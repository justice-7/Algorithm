import sys
input = sys.stdin.readline
import heapq
V,E = map(int, input().split())
k = int(input())
g = [[] for _ in range(V+1)]
for i in range(E):
    u,v,w = map(int, input().split())
    g[u].append((v,w))

inf = 100000000
d = [inf]*(V+1)
d[k] = 0
visit = [0]*(V+1)
q = []
heapq.heappush(q,(0,k))
while q:
    now = heapq.heappop(q)
    if visit[now[1]]==1:
        continue
    visit[now[1]]=1
    for nextV,nextW in g[now[1]]:
        if d[now[1]]+nextW<d[nextV]:
            d[nextV] = d[now[1]]+nextW
            heapq.heappush(q,(d[nextV],nextV))

for j in range(1,V+1):
    if d[j]==inf:
        print("INF")
    else:
        print(d[j])