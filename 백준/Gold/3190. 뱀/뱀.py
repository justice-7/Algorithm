from collections import deque

dir = "rdlu"
n = int(input())
k = int(input())
matrix = [[0]*(n+1) for _ in range(n+1)]
for _ in range(k):
    r,c = map(int, input().split())
    matrix[r][c] = 1
l = int(input())
move = []
for _ in range(l):
    x,c = input().split()
    move.append((int(x),c))
move.sort()

cnt = 0
now = (1,1)
snake = deque()
snake.append((1,1))
nD = 'r'
moveInd = 0
while True:
    #print(now,cnt)
    cnt+=1
    if nD =='r':
        nr = now[0]
        nc = now[1]+1
    elif nD =='l':
        nr = now[0]
        nc = now[1]-1
    elif nD =='u':
        nr = now[0]-1
        nc = now[1]
    elif nD == 'd':
        nr = now[0]+1
        nc = now[1]

    if moveInd<len(move) and cnt == move[moveInd][0]:
        if move[moveInd][1]=='D':
            nD = dir[(dir.find(nD)+1)%4]
        else:
            nD = dir[(dir.find(nD)+3)%4]
        moveInd+=1

    if nr<1 or nr>n or nc<1 or nc>n or (nr,nc) in snake:
        print(cnt)
        break

    snake.append((nr,nc))
    if matrix[nr][nc]==0:
        snake.popleft()
    else:
        matrix[nr][nc]=0
    now = (nr,nc)