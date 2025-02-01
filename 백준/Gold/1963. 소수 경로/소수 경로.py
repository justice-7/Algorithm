from collections import deque
t = int(input())
prime = set(range(2,10000))

for i in range(2, int(10000**0.5)):
    if i in prime:
        for j in range(i*i, 10000, i):
            if j in prime:
                prime.remove(j)
prime = set(filter(lambda x: x>=1000, prime))

def bfs(start, end):
    q = deque()
    q.append((start,0))
    visit = [0]*10000
    visit[start] = 1
    while q:
        now,cnt = q.popleft()
        if now == end:
            return cnt
        now = str(now)
        for i in range(4):
            for j in range(10):
                next = int(now[:i]+str(j)+now[i+1:])
                if visit[next]==0 and next in prime:
                    visit[next]=1
                    q.append((next,cnt+1))
    return "Impossible"
        
for _ in range(t):
    a,b = map(int, input().split())
    print(bfs(a,b))