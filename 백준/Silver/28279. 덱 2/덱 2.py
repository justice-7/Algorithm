import sys
from collections import deque
input = sys.stdin.readline
n = int(input())
d = deque()
for i in range(n):
    command = input().split()
    if command[0] == "1":
        d.appendleft(command[1])
    elif command[0] == "2":
        d.append(command[1])
    elif command[0] == "3":
        print(d.popleft() if len(d) else -1)
    elif command[0] == "4":
        print(d.pop() if len(d) else -1)
    elif command[0] == "5":
        print(len(d))
    elif command[0] == "6":
        print(0 if len(d) else 1)
    elif command[0] == "7":
        print(d[0] if len(d) else -1)
    elif command[0] == "8":
        print(d[-1] if len(d) else -1)