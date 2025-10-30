import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    n = int(input())
    ar = [list(map(int,input().split())) for _ in range(n)]
    ar.sort()
    mi = ar[0][1]
    cnt = 0
    for i in range(1,n):
        if mi > ar[i][1]:
            mi = ar[i][1]
        else:
            cnt+=1
    print(n-cnt)