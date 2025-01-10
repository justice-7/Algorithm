s = input()
result = "z"*51
for i in range(1,len(s)-1):
    for j in range(i+1,len(s)):
        a1 = s[:i]
        a2 = s[i:j]
        a3 = s[j:]

        ans = a1[::-1]+a2[::-1]+a3[::-1]
        result = min(result, ans)

print(result)