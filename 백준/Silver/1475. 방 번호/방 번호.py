import math
n = list(map(int, input()))
a = [0]*10
for i in n:
    a[i]+=1
a[6]=math.ceil((a[6]+a[9])/2)
a[9]=0
print(max(a))