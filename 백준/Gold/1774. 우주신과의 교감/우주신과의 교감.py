import sys,heapq, math
input = sys.stdin.readline

def comb(cnt, start, pick):
    if cnt ==2:
        w = math.sqrt((pos[pick[0]][0]-pos[pick[1]][0])**2+(pos[pick[0]][1]-pos[pick[1]][1])**2)
        heapq.heappush(pq, (w, pick[0],pick[1]))
        return 
    for i in range(start,n+1):
        pick[cnt] = i
        comb(cnt+1, i+1, pick)

def find(a):
    if parent[a] != a:
        parent[a] = find(parent[a])
    return parent[a]

def union(a,b):
    a = find(a)
    b = find(b)
    if a<b:
        parent[b] = a
    else:
        parent[a] = b

n,m = map(int, input().split())
pq = []
parent = list(range(n+1))
pos = [0]
for i in range(n):
    x,y = map(int, input().split())
    pos.append((x,y))
pick=[0]*2
comb(0,1,pick)
for j in range(m):
    a,b = map(int, input().split())
    union(a,b)

count = 0
resultW = 0
while count < n-1 and pq:
    w,u,v = heapq.heappop(pq)
    if find(u)!= find(v):
        union(u,v)
        count+=1
        resultW+=w
print("%.2f" %resultW)