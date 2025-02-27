import sys
input = sys.stdin.readline

def comb(a, cnt, start):
    if cnt == 6:
        print(*result)
        return
    for i in range(start, n):
        result[cnt] = a[i]
        comb(a, cnt+1, i+1)

while True:
    a = list(map(int, input().split()))
    if a[0]==0:
        break
    n = a[0]
    result = [0]*6
    comb(a[1:], 0, 0)
    print()