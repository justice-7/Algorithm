# 재귀, 배열
def dfs(x,y, depth):
    global result
    result = max(result, depth)
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if nx<0 or nx>=r or ny<0 or ny>=c:
            continue
        if alpha[ord(matrix[nx][ny])-65]==0:
            alpha[ord(matrix[nx][ny])-65]=1
            dfs(nx,ny,depth+1)
            alpha[ord(matrix[nx][ny])-65]=0

r,c = map(int, input().split())
matrix = [list(input()) for _ in range(r)]
dx,dy = [1,-1,0,0],[0,0,1,-1]
alpha = [0]*26
result = 0
alpha[ord(matrix[0][0])-65]=1
dfs(0,0,1)
print(result)