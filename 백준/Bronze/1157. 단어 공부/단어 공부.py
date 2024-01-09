s = input()
s = s.upper()
a = [0]*26
for i in range(len(s)):
    a[ord(s[i])-65]+=1
ma = a[0]
result = chr(0+65)
for j in range(1, 26):
    if ma < a[j]:
        ma = a[j]
        result = chr(j+65)
    elif ma == a[j]:
        result = "?"
print(result)