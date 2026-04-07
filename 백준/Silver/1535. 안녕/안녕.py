n = int(input())
strength = list(map(int, input().split()))
happy = list(map(int, input().split()))
dp = [[0]*101 for _ in range(n+1)]
for i in range(1, n+1):
    for j in range(1,101):
        if j <= strength[i-1]:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-strength[i-1]]+happy[i-1])
print(dp[n][100])