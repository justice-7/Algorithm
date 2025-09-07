def floyd():
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if g[i][k] and g[k][j]:
                    g[i][j]=1

n = int(input())
g = [list(map(int, input().split())) for _ in range(n)]
floyd()
for row in g:
    print(*row)