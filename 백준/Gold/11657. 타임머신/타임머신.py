import sys
input = sys.stdin.readline

def bellmanFord(start):
    dist[start]=0
    for j in range(n):
        for s,e,w in g:
            if dist[s]!=inf and dist[e] > dist[s] + w:
                dist[e] = dist[s] + w
                if j==n-1:
                    return False
    return True

n,m = map(int, input().split())
g = []
for i in range(m):
    a,b,c = map(int, input().split())
    g.append((a,b,c))

inf = 5000000
dist = [inf]*(n+1)
if not bellmanFord(1):
    print(-1)
else:
    for k in range(2,n+1):
        print(-1 if dist[k]==inf else dist[k])