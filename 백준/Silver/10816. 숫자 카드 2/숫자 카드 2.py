from collections import Counter
n = int(input())
a = Counter(list(map(int, input().split())))
m = int(input())
b = list(map(int, input().split()))
for i in range(m):
    print(a[b[i]] if b[i] in a else 0, end=" ")