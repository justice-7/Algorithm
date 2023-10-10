j,n = map(int, input().split())
cnt = 0
for i in range(n):
    s = input()
    size = 0
    for k in s:
        if 'A'<=k and k<='Z':
            size+=4
        elif 'a'<=k and k<='z':
            size+=2
        elif '0'<=k and k<='9':
            size+=2
        elif k==' ':
            size+=1
    if j >= size:
        cnt+=1
print(cnt)