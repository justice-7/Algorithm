n = int(input())
result = [0]*1000001
for i in range(10000001):
    hap = i+sum(list(map(int,str(i))))
    if hap > 1000000:
        break
    if result[hap]==0:
        result[hap] = i
print(result[n])