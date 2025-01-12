import sys, heapq
input = sys.stdin.readline
from collections import deque

def dijk():
    dist = [float('inf')]*(n+1)
    dist[s]=0
    pq = []
    heapq.heappush(pq,(0,s,[s]))
    while pq:
        nowW,nowV,route = heapq.heappop(pq)
        if nowV == e:
            return dist[e], route
        if dist[nowV] < nowW:
            continue
        for nextV,nextW in g[nowV]:
            if dist[nowV]+nextW < dist[nextV]:
                dist[nextV] = dist[nowV]+nextW
                heapq.heappush(pq, (dist[nextV], nextV, route+[nextV]))

n = int(input())
m = int(input())
g = [[] for _ in range(n+1)]
for i in range(m):
    u,v,w = map(int, input().split())
    g[u].append((v,w))
s,e = map(int, input().split())

minDist, route = dijk()

print(minDist)
print(len(route))
print(*route)