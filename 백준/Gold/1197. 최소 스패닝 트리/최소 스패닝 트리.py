import sys, heapq
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

v,e = map(int, input().split())
pq = [] 
parent = list(range(v+1))
for i in range(e):
    a,b,c = map(int, input().split())
    heapq.heappush(pq,(c,a,b))

def find(a):
    if a==parent[a]:
        return a
    else:
        parent[a] = find(parent[a])
        return parent[a]
    
def union(a, b):
    a = find(a)
    b = find(b)
    if a<b:
        parent[b] = a
    else:
        parent[a] = b

cnt = 0
result = 0
while cnt < v-1 and pq:
    w,s,e = heapq.heappop(pq)
    if find(s)!= find(e):
        union(s,e)
        cnt+=1
        result += w
print(result)