import sys, heapq
input = sys.stdin.readline
n = int(input())
pq = []
for i in range(n):
    a = int(input())
    heapq.heappush(pq, a)
result = 0
while(len(pq)!=1):
    x = heapq.heappop(pq)
    y = heapq.heappop(pq)
    heapq.heappush(pq,(x+y))
    result+=x+y
print(result)