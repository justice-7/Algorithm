def dfs(rN):
    parent[rN] = -10
    for i in range(n):
        if parent[i] == rN:
            dfs(i)

n = int(input())
parent = list(map(int, input().split()))
removeNode = int(input())
dfs(removeNode)

cnt = 0
for i in range(n):
    if parent[i] != -10 and i not in parent: 
        cnt += 1
print(cnt)