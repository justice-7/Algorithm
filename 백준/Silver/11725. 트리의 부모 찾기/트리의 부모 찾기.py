import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    result[start] = 1
    while q:
        now = q.popleft()
        for i in g[now]:
            if result[i]==0:
                result[i] = now
                q.append(i)

n = int(input())
g = [[] for _ in range(n+1)]
for i in range(n-1):
    a,b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

result = [0]*(n+1)
bfs(1)
print(*result[2:], sep="\n")