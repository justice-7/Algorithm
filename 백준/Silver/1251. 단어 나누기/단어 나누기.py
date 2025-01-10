def comb(cnt, n):
    if cnt ==2:
        if n>0:
            result.append("".join(reversed(s[:ar[0]]))+"".join(reversed(s[ar[0]:ar[0]+ar[1]]))+"".join(reversed(s[ar[0]+ar[1]:])))
        return
    for i in range(1,len(s)):
        ar[cnt] = i
        comb(cnt+1, n-i)

s = input()
ar = [0]*2
result = []
comb(0, len(s))
result.sort()
print(result[0])