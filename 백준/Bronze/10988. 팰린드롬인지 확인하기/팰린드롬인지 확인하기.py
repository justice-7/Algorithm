s = input()
result = 1
for i in range(len(s)//2):
    if s[i] != s[len(s)-1-i]:
        result = 0
        break
print(result)