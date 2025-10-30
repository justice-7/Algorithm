n = int(input())
a = [0]+[int(input()) for _ in range(n)]
visit = [0]*(n+1)
result = set()

def dfs(x, path):
    path.append(x)
    visit[x] = 1
    if visit[a[x]]==0:
        dfs(a[x], path)
    else:
        if a[x] in path:
            idx = path.index(a[x])
            result.update(path[idx:])

for i in range(1,n+1):
    if visit[i]==0:
        dfs(i, [])
result = sorted(list(result))
print(len(result))
print(*result, sep="\n")