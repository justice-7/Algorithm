def per(n, m, cnt, a, visit):
    if cnt==m:
        print(*a)
        return
    for i in range(1,n+1):
        if visit[i]==0:
            a[cnt] = i
            visit[i]=1
            per(n, m, cnt+1, a,visit)
            visit[i]=0

n,m = map(int,input().split())
a=[0]*m
visit=[0]*(n+1)
per(n,m, 0, a, visit)