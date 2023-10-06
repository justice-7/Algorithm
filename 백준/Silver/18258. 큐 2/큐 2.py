from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
q = deque()
result = []
for i in range(n):
    s = input().split()
    if s[0]=="push":
        q.append(s[1])
    elif s[0]=="pop":
        if len(q)==0:
            result.append(-1)
        else:
            result.append(q.popleft())
    elif s[0]=="size":
        result.append(len(q))
    elif s[0]=="empty":
        if len(q)==0:
            result.append(1)
        else:
            result.append(0)
    elif s[0]=="front":
        if len(q)==0:
            result.append(-1)
        else:
            result.append(q[0])
    elif s[0]=="back":
        if len(q)==0:
            result.append(-1)
        else:
            result.append(q[-1])
print(*result, sep="\n")