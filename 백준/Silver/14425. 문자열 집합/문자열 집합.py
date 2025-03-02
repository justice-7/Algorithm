n,m = map(int ,input().split())
s = set()
for i in range(n):
    s.add(input())
cnt = 0
for j in range(m):
    a = input()
    if a in s:
        cnt+=1
print(cnt)