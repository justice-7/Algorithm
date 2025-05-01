def solution(brown, yellow):
    answer = []
    for s in range(1,yellow+1):
        if s > yellow/s:
            break
        if yellow%s==0:
            g = yellow//s
            if brown == (g+2)*2+s*2:
                answer = [g+2,s+2]
            
    return answer