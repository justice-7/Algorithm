s = input()
flag = s[0]
cnt = 0
for i in range(1,len(s)):
    if flag != s[i]:
        cnt+=1 
        flag = s[i]
print((cnt+1)//2)