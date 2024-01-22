n,r,c = map(int, input().split())
result = 0
while (n!=0):
    n-=1
    size = 2**n
    if r < size and c >= size:
        result += size*size*1
        c -= size
    elif r >= size and c < size:
        result += size*size*2
        r -= size
    elif r >= size and c >= size:
        result += size*size*3
        c -= size
        r -= size
print(result)