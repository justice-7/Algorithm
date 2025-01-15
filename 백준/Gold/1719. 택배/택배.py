import sys
input = sys.stdin.readline
n,m = map(int, input().split())
inf = float('inf')
g = [[inf]*(n+1) for _ in range(n+1)]
result = [['-']*(1+n) for _ in range(n+1)]
for i in range(n+1):
    g[i][i]=0
for i in range(m):
    u,v,w = map(int,input().split())
    g[u][v] = w
    g[v][u] = w
    result[u][v] = v
    result[v][u] = u

for j in range(1,n+1):
    for s in range(1,n+1):
        for e in range(1,n+1):
            if g[s][e]>g[s][j]+g[j][e]:
                g[s][e] = g[s][j]+g[j][e]
                result[s][e] = result[s][j]

for i in range(1,n+1):
    for j in range(1,n+1):
        print(result[i][j], end=" ")
    print()