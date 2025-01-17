import sys,heapq
input = sys.stdin.readline
n = int(input())
lpq = []
rpq = []
for i in range(n):
    a = int(input())
    if not lpq or a<=-lpq[0]:
        heapq.heappush(lpq, -a)
    else:
        heapq.heappush(rpq, a)
    
    if len(lpq)<len(rpq):
        heapq.heappush(lpq, -heapq.heappop(rpq))
    elif len(lpq)>len(rpq)+1:
        heapq.heappush(rpq, -heapq.heappop(lpq))
    print(-lpq[0])