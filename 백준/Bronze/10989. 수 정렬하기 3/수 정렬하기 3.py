import sys
input = sys.stdin.readline
n = int(input())
a = [0]*10001
for i in range(n):
    a[int(input())]+=1
for j in range(1,10001):
    if a[j]!=0:
        for k in range(a[j]):
            print(j)