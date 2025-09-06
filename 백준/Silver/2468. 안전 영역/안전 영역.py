from collections import deque

dr,dc = [1,-1,0,0],[0,0,1,-1]
def bfs(i,j,k):
    q = deque()
    q.append([i,j])
    while q:
        r,c = q.popleft()
        for i in range(4):
            nr = dr[i]+r
            nc = dc[i]+c
            if nr<0 or nr>=n or nc<0 or nc>=n:
                continue
            if visit[nr][nc]==0 and g[nr][nc]>k:
                visit[nr][nc]=1
                q.append([nr,nc])

n = int(input())
g = [list(map(int, input().split())) for _ in range(n)]
ma,mi = 0,101
for i in range(n):
    ma = max(ma,max(g[i]))
    mi = min(mi, min(g[i]))

result = 0
for k in range(mi-1,ma+1): # mi-1: 아무 지역도 물에 잠기지 않을 수도 있다
    visit = [[0]*n for _ in range(n)]
    cnt = 0
    for i in range(n):
        for j in range(n):
            if g[i][j]>k and visit[i][j]==0:
                cnt+=1
                visit[i][j]=1
                bfs(i,j,k)
    result = max(result, cnt)
print(result)