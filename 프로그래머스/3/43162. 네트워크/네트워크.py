def solution(n, computers):
    answer = 0
    visit = [0]*n
    def dfs(x):
        for j in range(n):
            if computers[x][j]==1 and visit[j]==0:
                visit[j]=1
                dfs(j)

    for i in range(n):
        if visit[i]==0:
            visit[i]=1
            dfs(i)
            answer+=1
            
    return answer