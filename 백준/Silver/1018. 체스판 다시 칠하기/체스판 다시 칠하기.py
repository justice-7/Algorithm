def sol(x,y):
    global board
    w,b = 0,0
    for i in range(x, x+8):
        for j in range(y, y+8):
            if i%2==0:
                if j%2==0:
                    if board[i][j] != "W":  # W시작
                        w+=1
                    else:                   # B시작
                        b+=1
                else:
                    if board[i][j] != "B":
                        w+=1
                    else:
                        b+=1
            else:
                if j%2==0:
                    if board[i][j] != "B": 
                        w+=1
                    else:
                        b+=1
                else:
                    if board[i][j] != "W":
                        w+=1
                    else:
                        b+=1
    return min(w,b)

n,m = map(int, input().split())
board = [list(input()) for _ in range(n)]
result = 64
for i in range(n):
    for j in range(m):
        if i+8>n or j+8>m:
            continue
        result = min(result, sol(i,j))
print(result)