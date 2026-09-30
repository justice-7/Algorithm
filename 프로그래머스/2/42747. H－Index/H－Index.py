def solution(citations):
    citations.sort()
    n = len(citations)
    answer = 0
    for i in range(n):
        index = n-i
        if citations[i] >= index:
            return index
    return 0