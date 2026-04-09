from collections import deque

q = deque()
n = int(input())
indegree = [0]*(n+1)
time = [0]*(n+1)
g = [[] for _ in range(n+1)]
dp = [0]*(n+1)
for i in range(1,n+1):
    a = list(map(int, input().split()))
    time[i] = a[0]
    indegree[i] = a[1]
    for pre in a[2:]:
        g[pre].append(i)

for i in range(1,n+1):
    if indegree[i] == 0:
        q.append(i)
        dp[i] = time[i]
while q:
    now = q.popleft()
    for nxt in g[now]:
        indegree[nxt]-=1
        dp[nxt] = max(dp[nxt], dp[now]+time[nxt])
        if indegree[nxt] == 0:
            q.append(nxt)
print(max(dp))
