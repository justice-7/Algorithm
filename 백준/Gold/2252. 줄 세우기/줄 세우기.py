from collections import deque

n,m = map(int, input().split())
g = [[] for _ in range(n+1)]
degree = [0]*(n+1)
for i in range(m):
    a,b = map(int, input().split())
    g[a].append(b)
    degree[b]+=1

q = deque()
for j in range(1,n+1):
    if degree[j]==0:
        q.append(j)
while q:
    now = q.popleft()
    print(now, end=" ")
    for nx in g[now]:
        degree[nx]-=1
        if degree[nx]==0:
            q.append(nx)