import sys
from collections import Counter
input = sys.stdin.readline
n = int(input())
a = []
for i in range(n):
    a.append(int(input()))
print(round(sum(a)/n))
a.sort()
print(a[n//2])
cnt = Counter(a)
most = []
mostCommon = cnt.most_common()
for j in mostCommon:
    if j[1] == mostCommon[0][1]:
        most.append(j[0])
if len(most) > 1:
    most.sort()
    print(most[1])
else:
    print(mostCommon[0][0])
print(max(a)-min(a))