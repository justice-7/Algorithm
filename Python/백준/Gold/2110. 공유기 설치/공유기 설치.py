n,c = map(int,input().split())
ar = [0]*n
for i in range(n):
    ar[i] = int(input())
ar.sort()
start = 1
end = ar[n-1]-ar[0]

while start<=end:
    mid = start+(end-start)//2
    cur = 0
    cnt = 1
    for next in range(1,n):
        if ar[next]-ar[cur]>=mid:
            cnt+=1
            cur = next
    if cnt>=c:
        start = mid+1
    else:
        end = mid-1
print(end)