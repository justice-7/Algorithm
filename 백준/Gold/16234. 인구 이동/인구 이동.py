from collections import deque
def bfs(x,y,visit):
    global num,route
    q = deque()
    q.append((x,y))
    visit[x][y]=1
    num = matrix[x][y]
    route.append((x,y))
    while q:
        r,c = q.popleft()
        for i in range(4):
            nr = r+dr[i]
            nc = c+dc[i]
            if nr<0 or nr>=n or nc<0 or nc>=n:
                continue
            diff = abs(matrix[nr][nc]-matrix[r][c])
            if visit[nr][nc] ==0 and L <= diff and diff <= R:
                visit[nr][nc]=1
                q.append((nr,nc))
                route.append((nr, nc))
                num+=matrix[nr][nc]


dr,dc=[0,0,1,-1],[1,-1,0,0]
n,L,R = map(int, input().split())
matrix = [list(map(int, input().split())) for i in range(n)]
result = 0
while True:
    visit = [[0]*n for _ in range(n)]
    move = False
    for i in range(n):
        for j in range(n):
            if visit[i][j] == 0:
                num = 0
                route = []
                bfs(i,j,visit)
                cnt = len(route)
                if cnt>1:
                    move = True
                    fix = num//cnt
                    for r,c in route:
                        matrix[r][c]= fix
    if move:
        result+=1
    else:
        break
print(result)