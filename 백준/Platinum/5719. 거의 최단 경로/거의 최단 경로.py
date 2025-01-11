import sys, heapq
from collections import deque
input = sys.stdin.readline

def dijk():
    dist = [float('inf')]*n
    pq = []
    heapq.heappush(pq,(0,s))
    dist[s]=0
    while pq:
        nowW,nowV = heapq.heappop(pq)
        if nowW > dist[nowV]:
            continue
        for nextV,nextW in g[nowV]:
            if removeSE[nowV][nextV]==1:
                continue
            if dist[nowV]+nextW < dist[nextV]:
                dist[nextV] = dist[nowV]+nextW
                heapq.heappush(pq, (dist[nextV],nextV))
    return dist

def bfs(dist):
    q = deque()
    q.append(d)
    while q:
        now = q.popleft()
        for preV,preW in reverseG[now]:
            if dist[preV]+preW == dist[now] and removeSE[preV][now]==0:
                q.append(preV)
                removeSE[preV][now]=1


while True:
    n,m = map(int, input().split())
    g = [[] for _ in range(n)]
    reverseG = [[] for _ in range(n)]
    removeSE = [[0]*n for _ in range(n)]
    if n==0 and m==0:
        break
    s,d = map(int, input().split())
    for i in range(m):
        u,v,p = map(int, input().split())
        g[u].append((v,p))
        reverseG[v].append((u,p))

    dist = dijk()
    if dist[d]== float('inf'):
        print(-1)
        continue
    bfs(dist)
    dist = dijk()
    print(-1 if dist[d]==float('inf') else dist[d])