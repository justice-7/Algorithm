n = int(input())
a = list(map(int, input().split()))
result = 0
for i in range(n):
    isPrime = 1
    if a[i] == 1:
        isPrime = 0
    else:
        for j in range(2,a[i]):
            if a[i] % j == 0:
                isPrime = 0
                break
    if isPrime:
        result += 1
print(result)