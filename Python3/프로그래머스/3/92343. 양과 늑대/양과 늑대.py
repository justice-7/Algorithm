from collections import defaultdict
def solution(info, edges):
    answer = 0
    g = defaultdict(list)
    for parent, child in edges:
        g[parent].append(child)    


    def dfs(sheep,wolf, cur, possible):
        nonlocal answer
        
        if info[cur] == 0:
            sheep+=1
        else:
            wolf+=1
        if wolf>= sheep:
            return 
        answer = max(answer,sheep)
        
        nextPossible = possible + g[cur]
        nextPossible.remove(cur)
        for next in nextPossible:
            dfs(sheep, wolf, next, nextPossible[:]) # 깊은 복사
    dfs(0,0,0,[0])
    return answer
