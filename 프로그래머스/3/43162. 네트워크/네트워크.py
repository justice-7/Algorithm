def solution(n, computers):
    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]
    def union(a,b):
        a = find(a)
        b = find(b)
        if a<b:
            parent[b] = a
        else:
            parent[a] = b
    
    parent = list(range(n))
    for i in range(n):
        for j in range(n):
            if computers[i][j] == 1:
                union(i,j)
    for k in range(n):
        k = find(k)
    
    return len(set(parent))