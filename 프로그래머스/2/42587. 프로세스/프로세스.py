from collections import deque
def solution(priorities, location):
    answer = 0
    q = deque((p,l) for l,p in enumerate(priorities))
    num = [0]*10
    for i in priorities:
        num[i] += 1
    best = 9
    while q:
        while num[best]==0 and best>1:
            best-=1
        now = q.popleft()
        if now[0]==best:
            answer+=1
            if now[1]==location:
                break
            num[best]-=1
        else:
            q.append(now)
            
    return answer