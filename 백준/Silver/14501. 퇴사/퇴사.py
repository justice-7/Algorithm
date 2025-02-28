import sys
input = sys.stdin.readline

def sol(start, total):
    global result
    result = max(result,total)
    for i in range(start, n):
        if (i+ar[i][0]-1<n):
            sol(i+ar[i][0],total+ar[i][1])

n = int(input())
ar = []
result = 0
for i in range(n):
    t,p = map(int, input().split())
    ar.append((t,p))
sol(0,0)
print(result)