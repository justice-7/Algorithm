s = input()
ar = []
for i in range(len(s)):
    ar.append(s[i:])
ar.sort()
print(*ar, sep='\n')