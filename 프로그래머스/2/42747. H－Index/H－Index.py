# def solution(citations):
#     citations.sort()
#     n = len(citations)
#     answer = 0
#     for i in range(n):
#         index = n-i
#         if citations[i] >= index:
#             return index
#     return 0
def solution(citations):
    citations.sort()
    n = len(citations)
    answer = 0
    left = 0
    right = n
    while left <= right:
        mid = left+(right-left)//2
        cnt = sum(1 for i in citations if i>=mid)
        if mid<=cnt:
            left = mid+1
        else:
            right = mid-1
    return right