n = int(input())
a = list(map(int, input().split()))
hap = [a[0]]
for i in range(1,n):
    hap.append(hap[i-1]+a[i])

result = 0
for j in range(n):
    result += a[j]*(hap[n-1]-hap[j])
print(result)