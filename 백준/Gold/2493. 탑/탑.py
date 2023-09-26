import sys
input = sys.stdin.readline
n = int(input())
a = list(map(int, input().split()))
top = [] # 위치, 높이
result = [0]*n
for i in range(n):
    while top:
        if a[i] > top[-1][1]:
            top.pop()
        else:
            result[i] = top[-1][0]
            break
    top.append((i+1, a[i]))
print(*result) 