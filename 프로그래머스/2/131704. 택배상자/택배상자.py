from collections import deque
def solution(order):
    a = deque(range(1, len(order)+1))
    sub = []
    answer = 0
    ind = 0
    while a or sub:
        if a and a[0]==order[ind]:
            ind+=1
            answer+=1
            a.popleft()
        elif sub and sub[-1]==order[ind]:
            ind+=1
            answer+=1
            sub.pop()
        elif a:
            sub.append(a.popleft())
        else:
            break
    return answer