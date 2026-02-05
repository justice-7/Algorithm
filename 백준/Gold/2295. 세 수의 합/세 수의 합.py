n = int(input())
u = list(int(input()) for _ in range(n))
hap = []
u.sort()
for i in range(n):
    for j in range(n):
        hap.append(u[j]+u[i])

hap.sort()
for i in range(n-1,-1,-1):
    for j in range(i):
        target = u[i]-u[j]
        start = 0
        end = len(hap) - 1
        while start <= end:
            mid = start+(end-start)//2
            if hap[mid]==target:
                print(u[i])
                exit()
            elif hap[mid]<target:
                start = mid+1
            else:
                end = mid-1
