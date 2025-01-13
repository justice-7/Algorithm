n = int(input())
ar  = []
for i in range(n):
    x,y = map(int, input().split())
    ar.append((x,y))
for j in range(n):
    cnt = 0
    for k in range(n):
        if j!=k and ar[j][0]<ar[k][0] and ar[j][1]<ar[k][1]:
            cnt+=1
    print(cnt+1, end=" ")