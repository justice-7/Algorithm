n = int(input())
k = int(input())
start = 1
end = k # k번째 수는 k 이하
while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for i in range(1,n+1):
        cnt += min(n, mid//i) # 각 행에 있는 원소 개수 제한(n)
    if cnt >= k:
        end = mid - 1
    else:
        start = mid + 1
print(start)