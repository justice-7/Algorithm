import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    n = int(input())
    ar = [list(map(int,input().split())) for _ in range(n)]
    rank = [0]*(n+1)
    for i in range(n):
        rank[ar[i][0]] = ar[i][1]
    mi = float('inf')
    cnt = 0
    for j in range(1,n+1):
        if mi>rank[j]:
            mi = rank[j]
        else:
            cnt+=1
    print(n-cnt)