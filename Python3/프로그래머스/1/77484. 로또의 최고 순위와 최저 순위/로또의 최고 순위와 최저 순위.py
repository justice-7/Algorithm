def solution(lottos, win_nums):
    rank = {6:1, 5:2, 4:3, 3:4, 2:5, 1:6, 0:6}
    right,zero = 0,0
    for now in lottos:
        if now == 0:
            zero += 1
        elif now in win_nums:
            right+=1
            
    answer = [rank[right+zero],rank[right]]
    
    return answer