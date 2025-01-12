n,x = map(int, input().split())
ar = [0]+list(map(int, input().split()))
for i in range(1, n+1):
    ar[i] = ar[i-1]+ar[i]
result = []
for j in range(x, n+1):
    result.append(ar[j]-ar[j-x])
ma = max(result)
if ma==0:
    print("SAD")
else:
    print(ma)
    print(result.count(ma))