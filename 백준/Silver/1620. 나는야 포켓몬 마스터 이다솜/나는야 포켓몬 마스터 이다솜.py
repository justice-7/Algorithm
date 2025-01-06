import sys
input = sys.stdin.readline

n,m = map(int, input().split())
nameToNum = dict()
numToName = dict()
for i in range(1,n+1):
    s = input().rstrip()
    nameToNum[s] = i
    numToName[i] = s
for j in range(m):
    ss = input().rstrip()
    if ss.isdigit():
        print(numToName[int(ss)])
    else:
        print(nameToNum[ss])