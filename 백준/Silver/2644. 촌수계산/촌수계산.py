n = int(input())
a,b = map(int, input().split())
g = [[] for _ in range(n+1)]
m = int(input())
for i in range(m):
    x,y = map(int, input().split())
    g[x].append(y)
    g[y].append(x)
result = -1
def dfs(x,depth):
    global result
    visit[x]=1
    if x==b:
        result = depth
        return
    for i in g[x]:
        if visit[i]==0:
            dfs(i,depth+1)
visit = [0]*(n+1)
dfs(a,0)
print(result)