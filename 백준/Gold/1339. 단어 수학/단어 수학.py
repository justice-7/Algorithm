n = int(input())
al = [[0,i] for i in range(26)]
for i in range(n):
    s = input()
    for j in range(len(s)):
        al[ord(s[j])-ord('A')][0]+=10**(len(s)-j-1)
al.sort(reverse=True)
result = 0
for k in range(9):
    if al[k][0]==0:
        break
    result += al[k][0]*(9-k)
print(result)