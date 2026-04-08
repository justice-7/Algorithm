n,m = map(int, input().split())
a = list(map(int, input().split()))
start = 0
end = 1000000000
while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for i in a:
        cnt += max(0, i - mid)
    if cnt >= m:
        start = mid + 1
    else:
        end = mid - 1
print(end)