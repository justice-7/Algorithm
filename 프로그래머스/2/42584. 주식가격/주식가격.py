from collections import deque
def solution(prices):
    n = len(prices)
    answer = [0]*len(prices)
    st = deque()
    for i in range(n-1,-1,-1):
        while st and prices[i] <= prices[st[-1]]:
            st.pop()
        if not st:
            answer[i] = n-1-i
        else:
            answer[i] = st[-1]-i
        st.append(i)

    return answer