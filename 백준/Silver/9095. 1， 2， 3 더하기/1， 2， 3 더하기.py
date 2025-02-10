dp = [0]*12
dp[1] = 1
dp[2] = 2
dp[3] = 4
for j in range(4,12):
    dp[j] = dp[j-1]+dp[j-2]+dp[j-3]
    
t = int(input())
for i in range(t):
    n = int(input())
    print(dp[n])