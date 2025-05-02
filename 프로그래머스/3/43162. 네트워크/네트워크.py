def solution(n, computers):
    
    def dfs(x):
        visit[x] = 1
        for y in range(n):
            if computers[x][y]==1 and visit[y]==0:
                dfs(y)
            
    answer = 0
    visit = [0]*n
    for i in range(n):
        if visit[i]==0:
            dfs(i)
            answer+=1
    return answer


    