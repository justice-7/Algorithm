def dfs(node,parent):
    global cycle
    visit[node] = 1
    for nx in tree[node]:
        if visit[nx]==0:
            dfs(nx, node)
        elif nx != parent:
            cycle = True


tc = 0
while True:
    tc+=1
    n,m = map(int, input().split())
    tree = [[] for _ in range(n+1)]
    if n==0 and m==0:
        break
    for _ in range(m):
        s,e = map(int, input().split())
        tree[s].append(e)
        tree[e].append(s)

    visit = [0]*(n+1)
    cnt = 0
    for i in range(1, n+1):
        if visit[i]==0:
            cycle = False
            dfs(i,0)
            if not cycle:
                cnt+=1
    if cnt == 0:
        print(f"Case {tc}: No trees.")
    elif cnt == 1:
        print(f"Case {tc}: There is one tree.")
    else:
        print(f"Case {tc}: A forest of {cnt} trees.")