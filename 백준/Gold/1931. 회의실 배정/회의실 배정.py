n = int(input())
t = [list(map(int, input().split())) for _ in range(n)]
t.sort(key = lambda x: (x[1],x[0]))
cnt = 1
start = t[0][1]
for i in range(1,n):
    if start<=t[i][0]:
        start=t[i][1]
        cnt+=1
print(cnt)