n,k = map(int,input().split())
a = list(map(int,input().split()))
cnt =0
start = 0
end = 0
result = 10000000
if a[0]==1:
    cnt+=1

while start<=end and end<n:
    if cnt<k:
        end+=1
        if end>=n:
            break
        if a[end] == 1:
            cnt += 1
    elif cnt >= k:
        result = min(result,end-start+1)
        if a[start]==1:
            cnt-=1
        start+=1

print(-1 if result==10000000 else result)