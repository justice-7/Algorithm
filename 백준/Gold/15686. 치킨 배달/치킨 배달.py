def comb(nn,r,start,cnt):
    global result
    if cnt == r:
        result = min(result,cal())
        return
    for i in range(start,len(ch)):
        select[cnt] = i
        comb(nn,r,i+1,cnt+1)

def cal():
    d = [1000] * len(house)
    for i in range(len(house)):
        for j in range(len(select)):
            d[i] = min(d[i],abs(house[i][0]-ch[select[j]][0])+abs(house[i][1]-ch[select[j]][1]))
    return sum(d)

n,m = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(n)]
house = []
ch = []
select = [0]*m
result = float('inf')
for i in range(n):
    for j in range(n):
        if map[i][j] == 1:
            house.append((i, j))
        elif map[i][j] == 2:
            ch.append((i, j))
comb(len(ch),m,0,0)
print(result)