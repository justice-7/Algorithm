from collections import deque
n,m = map(int, input().split())
a= [0]*101
for _ in range(n):
    x,y = map(int, input().split())
    a[x] = y
for _ in range(m):
    u,v = map(int, input().split())
    a[u] = v
visit = [0]*101
def bfs(node):
    q = deque()
    q.append((node,0))
    visit[node] = 1
    while q:
        nowN,nowCnt = q.popleft()
        if nowN == 100:
            print(nowCnt)
        for i in range(1,7):
            next = nowN+i
            if next <= 100 and visit[next]==0:
                visit[next] = 1
                if a[next] == 0:
                    q.append((next, nowCnt+1))
                else:
                    q.append((a[next],nowCnt+1))

bfs(1)