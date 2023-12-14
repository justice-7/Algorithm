n,m = map(int, input().split())
a = set()
b = set()
for i in range(n):
    a.add(input())
for j in range(m):
    b.add(input())
result = sorted(list(a&b)) # 사전순
print(len(result))
print(*result, sep="\n")