import sys
input = sys.stdin.readline
n = int(input())
ar = []
for i in range(n):
    ar.append(int(input()))
ar.sort()
result = 0
for j in range(n):
    result = max(result,ar[j]*(n-j))
print(result)