def solution(sales, links):
    answer  = 0

    n = len(sales)
    choice = [0]*(n+1)
    g = [[] for _ in range(n+1)]
    for p,c in links:
        g[p].append(c)

    dp = [[0,0] for _ in range(n+1)]
    
    def dfs(a):
        dp[a][0] = 0
        dp[a][1] = sales[a-1]
        
        if not g[a]:
            return
        extra_cost = float('inf')
        for child in g[a]:
            dfs(child)
            if dp[child][0] < dp[child][1]:
                dp[a][0]+=dp[child][0]
                dp[a][1]+=dp[child][0]
                extra_cost = min(extra_cost, dp[child][1]-dp[child][0])
            else:
                dp[a][0]+=dp[child][1]
                dp[a][1]+=dp[child][1]
                extra_cost = 0
        dp[a][0] += extra_cost
                
    dfs(1)
    return min(dp[1][0],dp[1][1])