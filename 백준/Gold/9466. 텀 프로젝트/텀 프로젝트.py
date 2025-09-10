import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(x):
    global cnt
    visit[x] = 1
    nx = a[x]

    if visit[nx]==0:
        dfs(nx)
    elif visit[nx]==1:
        cycle = 1
        cur = nx
        while a[cur]!= nx:
            cur = a[cur]
            cycle+=1
        cnt+=cycle
    visit[x]=2

t = int(input())
for i in range(t):
    n = int(input())
    a = [0]+list(map(int, input().split()))
    cnt = 0
    visit = [0]*(n+1) # 0=미방문, 1=방문중, 2=완료
    for j in range(1,n+1):
        if visit[j]==0:
            dfs(j)
            #print(j, visit,cnt)
    print(n-cnt)