import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(now):
    for next in g[now]:
        if visit[next]==0:
            visit[next] = 1
            parent[next] = now
            dfs(next)

n = int(input())
g = [[] for _ in range(n+1)]
visit = [0]*(n+1)
parent = [0]*(n+1)
for i in range(n-1):
    a,b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)
visit[1] = 1
dfs(1)
print(*parent[2:],sep="\n")