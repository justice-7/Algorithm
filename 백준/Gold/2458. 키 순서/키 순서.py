def dfs(x,g):
    for j in g[x]:
        if visit[j]==0:
            visit[j]=1
            cnt[j]+=1
            dfs(j,g)

n,m = map(int, input().split())
g = [[] for i in range(n+1)]
reverseG = [[] for i in range(n+1)]
cnt = [0]*(n+1)
for i in range(m):
    a,b = map(int,input().split())
    g[a].append(b)
    reverseG[b].append(a)

for i in range(1, n + 1):
    visit = [0]*(n+1)
    visit[i] = 1
    dfs(i,g)
    dfs(i,reverseG)

#print(cnt)
print(sum(1 if j==n-1 else 0 for j in cnt))