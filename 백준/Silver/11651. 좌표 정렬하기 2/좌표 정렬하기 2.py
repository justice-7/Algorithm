n = int(input())
a = []
for i in range(n):
    x,y = map(int, input().split())
    a.append([x,y])
a = sorted(a, key=lambda x:(x[1],x[0]))
for j in a:
    print(j[0], j[1])