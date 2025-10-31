k,n = map(int, input().split())
line = [int(input()) for _ in range(k)]
start = 1
end = max(line)
while start <= end:
    mid = start + (end - start) // 2
    cnt = 0
    for length in line:
        cnt+= length//mid
    if cnt >= n:
        start = mid + 1
    else:
        end = mid-1
print(end)