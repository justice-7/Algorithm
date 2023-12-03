d = {}
n = int(input())
for i in range(n):
    s = input()
    if s in d:
        d[s]+=1
    else:
        d[s] = 1
sortD = sorted(d.items(), key = lambda item: (-item[1],item[0]))
print(sortD[0][0])