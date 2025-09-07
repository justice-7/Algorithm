def find(x):
    if x != parent[x]:
        parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    a = find(a)
    b = find(b)
    if a==b:
        cycle.add(a) # 사이클
    elif a<b:
        parent[b] = a
    else:
        parent[a] = b
tc = 0
while True:
    tc+=1
    n,m = map(int, input().split())
    if n==0 and m==0:
        break

    parent = list(range(n+1))
    cycle = set()
    for _ in range(m):
        s,e = map(int, input().split())
        union(s,e)

    roots = set(find(i) for i in range(1, n+1))
    cycle = set(find(i) for i in cycle)
    cnt = len(roots- cycle)
    if cnt ==0:
        print(f"Case {tc}: No trees.")
    elif cnt ==1:
        print(f"Case {tc}: There is one tree.")
    else:
        print(f"Case {tc}: A forest of {cnt} trees.")