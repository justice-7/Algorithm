import sys
input = sys.stdin.readline

def dfs(now, cnt):
    global result
    if cnt >=4:
        result = 1
        return
    for next in g[now]:
        if visit[next] == 0:
            visit[next] = 1
            dfs(next,cnt+1)
            visit[next] = 0

n,m = map(int, input().split())
visit = [0]*n
g = [[] for _ in range(n)]
for i in range(m):
    a,b = map(int, input().split())
    g[a].append(b)
    g[b].append(a)

result = 0
for j in range(n):
    visit[j] = 1
    dfs(j,0)
    if result == 1:
        break
    visit[j] = 0
print(result)