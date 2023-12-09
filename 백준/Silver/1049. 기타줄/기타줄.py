n,m = map(int, input().split())
six,one=[],[]
for i in range(m):
    s,o = map(int, input().split())
    six.append(s)
    one.append(o)
minS = min(six)
minO = min(one)
result = 0
if minS < minO*6:
    result = (n//6)*minS 
    if (n%6)*minO > minS:
        result += minS
    else:
        result += (n%6)*minO
else:
    result = minO*n
print(result)