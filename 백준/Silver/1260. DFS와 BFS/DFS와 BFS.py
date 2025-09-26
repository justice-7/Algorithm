import sys
from collections import deque

input = sys.stdin.readline

def dfs(g, visit, a):
    visit[a] = 1
    print(a, end=" ")
    for i in g[a]:
        if visit[i]==0:
            dfs(g, visit, i)


def bfs(g, visit, a):
    q = deque()
    q.append(a)
    visit[a] = 1
    while q:
        now = q.popleft()
        print(now, end=" ")
        for next in g[now]:
            if visit[next]==0:
                q.append(next)
                visit[next] = 1

n,m,v = map(int, input().split())
g = [[] for _ in range(n+1)]

for _ in range(m):
    a,b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)
for i in range(1,n+1):
    g[i].sort()

visit = [0]*(n+1)
dfs(g, visit, v)
print()
visit = [0]*(n+1)
bfs(g, visit, v)