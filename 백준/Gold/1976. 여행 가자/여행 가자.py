def find(x):    
    if x==parent[x]:
        return x
    parent[x] = find(parent[x])
    return parent[x]

def union(a,b):
    a = find(a)
    b = find(b)
    if a<b:
        parent[b] = a
    else:
        parent[a] = b  

n = int(input())
m = int(input())
parent = list(range(n+1))
for i in range(1,n+1):
    inp = list(map(int, input().split()))
    for j in range(n):
            if inp[j]==1:
                union(i,j+1)
plan = list(map(int, input().split()))

result = "YES"
for i in range(m-1):
    if find(plan[i]) != find(plan[i+1]):
        result = "NO"
        break
print(result)