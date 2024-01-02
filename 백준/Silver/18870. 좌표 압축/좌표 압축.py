n = int(input())
a = list(map(int, input().split()))
b = list(set(a))
b.sort()
dic = {b[i]:i for i in range(len(b))}
for j in a:
    print(dic[j], end=" ")