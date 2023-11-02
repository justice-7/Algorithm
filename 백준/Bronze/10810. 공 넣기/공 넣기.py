import sys
input = sys.stdin.readline
n,m = map(int, input().split())
basket = [0]*(n+1)
for x in range(m):
    i,j,k = map(int, input().split())
    for y in range(i,j+1):
        basket[y] = k
print(*basket[1:])