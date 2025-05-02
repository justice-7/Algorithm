def solution(n, computers):
    global parent
    parent = list(range(n))
    for i in range(len(computers)):
        for j in range(len(computers[0])):
            if i!=j and computers[i][j]==1:
                union(i,j)
    return len(set(find(i) for i in range(n)))

def union(a,b):
    a = find(a)
    b = find(b)
    if a>b:
        parent[a] = b
    else:
        parent[b] = a
    
def find(x):
    if x==parent[x]:
        return x
    parent[x] = find(parent[x])
    return parent[x]