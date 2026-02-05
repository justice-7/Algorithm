def find(x):
    if parent[x] == x:
        return x
    parent[x] = find(parent[x])
    return parent[x]
def union(x,y):
    x = find(x)
    y = find(y)
    if x == y:
        return
    if x<y:
        parent[y] = x
        size[x] += size[y]
        size[y] = 0
    else:
        parent[x] = y
        size[y] += size[x]
        size[x] =0

t = int(input())
for i in range(t):
    name = {}
    f = int(input())
    num = 0
    parent = list(range(f*2))
    size =[1]*(f*2)
    for j in range(f):
        a,b = input().split()
        if a not in name:
            name[a] = num
            num += 1
        if b not in name:
            name[b] = num
            num+=1

        union(name[a],name[b])
        print(size[find(name[a])])