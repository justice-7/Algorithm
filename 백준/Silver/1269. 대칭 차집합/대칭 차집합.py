a,b = map(int,input().split())
aset = set(map(int, input().split()))
bset = set(map(int, input().split()))
result = (aset-bset) | (bset-aset)
print(len(result))