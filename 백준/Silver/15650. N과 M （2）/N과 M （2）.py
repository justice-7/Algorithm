def per(cnt, start):
    if cnt == m:
        print(*ar)
        return
    for i in range(start,n+1):
        ar[cnt] = i
        per(cnt+1, i+1)

n,m = map(int, input().split())
ar = [0]*m
per(0, 1)