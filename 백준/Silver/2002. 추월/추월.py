n = int(input())
d = [input() for _ in range(n)]

result = 0
for _ in range(n):
    a = input()
    if d[0] != a:
        result+=1
    d.remove(a)
print(result)