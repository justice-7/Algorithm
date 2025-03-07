n,m = map(int, input().split())
ar = list(map(int, input().split()))
start = max(ar)
end = sum(ar)
while start<=end:
    mid = start+(end-start)//2
    cnt = 1
    lenght=0
    for i in ar:
        if lenght+i > mid:
            lenght = 0
            cnt+=1
        lenght+=i
    if cnt > m:
        start = mid+1
    else:
        end = mid-1
print(start)