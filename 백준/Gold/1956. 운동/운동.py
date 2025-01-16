import sys
input = sys.stdin.readline

v,e = map(int, input().split())
inf = float('inf')
g = [[inf]*(v+1) for _ in range(v+1)]

for _ in range(e):
    a,b,c = map(int, input().split())
    g[a][b] = c
for j in range(1,v+1):
    for s in range(1,v+1):
        for e in range(1,v+1):
            g[s][e] = min(g[s][e], g[s][j]+g[j][e])
result = inf
for k in range(1,v+1):
    result = min(result, g[k][k])
print(result if result!=inf else -1)