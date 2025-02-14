n = int(input())

dp = [[0]*3 for _ in range(n)]
cost = [[0]*3 for _ in range(n)]
for i in range(n):
    r,g,b = map(int, input().split())
    cost[i][0],cost[i][1],cost[i][2]=r,g,b

dp[0][0],dp[0][1],dp[0][2] = cost[0][0],cost[0][1],cost[0][2]
for j in range(1,n):
    dp[j][0] = min(dp[j-1][1],dp[j-1][2])+cost[j][0]
    dp[j][1] = min(dp[j-1][0],dp[j-1][2])+cost[j][1]
    dp[j][2] = min(dp[j-1][0],dp[j-1][1])+cost[j][2]
    
print(min(dp[n-1][0],dp[n-1][1],dp[n-1][2]))