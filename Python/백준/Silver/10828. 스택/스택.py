import sys
input = sys.stdin.readline
n = int(input())
stack = []
for i in range(n):
    a = input().split()
    if a[0]=="push":
        stack.append(a[1])
    elif a[0]=="pop":
        print(-1 if len(stack)==0 else stack.pop())
    elif a[0]=="size":
        print(len(stack))
    elif a[0]=="empty":
        print(1 if len(stack)==0 else 0)
    elif a[0]=="top":
        print(-1 if len(stack)==0 else stack[-1])