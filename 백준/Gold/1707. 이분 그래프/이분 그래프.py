import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    visit[start] = 1
    while q:
        now = q.popleft()
        for next in g[now]:
            if visit[next]==0:
                visit[next] = -visit[now]
                q.append(next)
            elif visit[next] == visit[now]:
                return False
    return True

k = int(input())
for i in range(k):
    V,E = map(int,input().split())
    visit = [0]*(V+1)
    g = [[] for _ in range(V+1)]
    for j in range(E):
        u,v = map(int, input().split())
        g[u].append(v)
        g[v].append(u)
    result = True
    for k in range(1,V+1):
        if visit[k] == 0:
            if not bfs(k):
                result = False
                break
    print("YES" if result else "NO")