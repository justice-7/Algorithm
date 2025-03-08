import sys, heapq
input = sys.stdin.readline

def dijk(start,end):
    hq = []
    heapq.heappush(hq, (0,start))
    dist = [float('inf')]*(n+1)
    dist[start]=0
    while (hq):
        nowd,now = heapq.heappop(hq)
        if nowd > dist[now]:
            continue 
        for next,w in g[now]:
            if dist[now]+w < dist[next]:
                dist[next] = dist[now]+w
                heapq.heappush(hq,(dist[next],next))
    return dist[end] if dist[end]!=float('inf') else -1

n,e = map(int, input().split())
g = [[] for _ in range(n+1)]
for _ in range(e):
    a,b,c= map(int, input().split())
    g[a].append((b,c))
    g[b].append((a,c))
v1,v2 = map(int, input().split())
a1,b,c1 = dijk(1,v1),dijk(v1,v2),dijk(v2,n)
a2,c2 = dijk(1,v2),dijk(v1,n)
result = 200000000
if a1 != -1 and b !=-1 and c1!=-1:
    result = a1+b+c1
if a2 != -1 and b!=-1 and c2!=-1:
    result = min(result, a2+b+c2)
else:
    result = -1
print(result)
    