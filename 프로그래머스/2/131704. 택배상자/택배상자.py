def solution(order):
    sub = []
    ind = 0 
    for i in range(1, len(order)+1):
        if i==order[ind]:
            ind+=1
        else:
            sub.append(i)
        while sub and sub[-1]==order[ind]:
            ind+=1
            sub.pop()
        
    return ind