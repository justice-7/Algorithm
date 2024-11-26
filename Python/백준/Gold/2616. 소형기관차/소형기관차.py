n = int(input())
ar = list(map(int, input().split()))
maxCnt = int(input())
for i in range(1,len(ar)):
    ar[i] += ar[i-1]
ar.insert(0,0)

# i번째 소형기관차가 객차 j까지 봤을 때 운송할 수 있는 최대 승객 수
dp = [[0]*(n+1) for _ in range(4)]
for i in range(1,4):
    for j in range(i*maxCnt, n+1):
        dp[i][j] = max(dp[i][j-1], # j번째 객체 포함X
                       dp[i-1][j-maxCnt]+(ar[j]-ar[j-maxCnt])) # j번째 객차 포함O
print(dp[3][n])