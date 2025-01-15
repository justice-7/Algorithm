import sys
input = sys.stdin.readline

n = int(input())
m = int(input())
inf = float('inf')
g = [[inf]*(n+1) for _ in range(n+1)]
for i in range(n+1):
    for j in range(n+1):
        if i==j:
            g[i][j]=0
for k in range(m):
    a,b,c =map(int, input().split())
    g[a][b] = min(g[a][b],c)

for i in range(1,n+1):
    for s in range(1,n+1):
        for e in range(1,n+1):
            g[s][e] = min(g[s][e], g[s][i]+g[i][e])

for j in range(1,n+1):
    for k in range(1,n+1):
        if g[j][k] == inf:
            print(0, end=' ')
        else:
            print(g[j][k], end=' ')
    print()