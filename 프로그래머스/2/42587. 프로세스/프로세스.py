from collections import deque
def solution(priorities, location):
    answer = 0
    p = deque(priorities)
    num = [0]*10
    for i in priorities:
        num[i] += 1
    best = 9
    l=deque([0]*len(priorities))
    l[location] = 1
    print(p)
    while True:
        while num[best]==0 and best>1:
            best-=1
        if p[0]==best:
            answer+=1
            if l[0]==1:
                break
            p.popleft()
            l.popleft()
            num[best]-=1
        else:
            p.append(p.popleft())
            l.append(l.popleft())
            
    return answer