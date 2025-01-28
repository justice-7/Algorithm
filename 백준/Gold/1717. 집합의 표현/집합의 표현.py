import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def find(a):
    if parent[a] != a:
        parent[a] = find(parent[a])
    return parent[a]

def union(a,b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

n,m = map(int,input().split())
parent = list(range(n+1))
for _ in range(m):
    c,a,b = map(int,input().split())
    if c==0:
        union(a,b)
    else:
        if find(a)==find(b):
            print("YES")
        else:
            print("NO")