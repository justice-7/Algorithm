import sys
input = sys.stdin.readline
import heapq

n,m,x = map(int, input().split())
g = [[] for _ in range(n+1)]
inf = 100000
result = [0]*(n+1)
for i in range(m):
    s,e,t = map(int, input().split())
    g[s].append((e,t))

for j in range(1,n+1):
    visit = [0]*(n+1)
    d = [inf]*(n+1)
    d[j] = 0
    q = []
    heapq.heappush(q, (0,j))
    while q:
        now = heapq.heappop(q)
        if visit[now[1]]==1:
            continue
        visit[now[1]]=1
        for nextV, nextW in g[now[1]]:
            if d[now[1]]+nextW < d[nextV]:
                d[nextV] = d[now[1]]+nextW
                heapq.heappush(q, (d[nextV],nextV))
    if j==x:
        for k in range(1, n+1):
            result[k]+=d[k]
    result[j] += d[x]
print(max(result))