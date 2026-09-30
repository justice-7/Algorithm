def solution(numbers):
    n = len(numbers)
    answer = [0] * n
    st = []
    for i in range(n-1,-1,-1):
        while st and st[-1] <= numbers[i]:
            st.pop()
        if len(st)==0:
            answer[i] = -1
        else:
            answer[i] = st[-1]
        st.append(numbers[i])
    return answer