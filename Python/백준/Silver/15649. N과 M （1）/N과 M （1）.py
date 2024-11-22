def per(cnt):
    if cnt==m:
        print(*a)
        return
    for i in range(1,n+1):
        if visit[i]==0:
            a[cnt] = i
            visit[i]=1
            per(cnt+1)
            visit[i]=0

n,m = map(int,input().split())
a=[0]*m
visit=[0]*(n+1)
per(0)