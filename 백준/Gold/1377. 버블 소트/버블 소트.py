# []로 배열 생성
import sys
input = sys.stdin.readline
n = int(input())
a = []
for k in range(n):
    a.append((int(input()), k))

# 몇 번 돌아야 정렬되는가
a.sort()
result = -1
for i in range(n):
    diff = a[i][1]-i
    if result < diff:
        result = diff
print(result+1)