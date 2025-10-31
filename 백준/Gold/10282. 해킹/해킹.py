import heapq, sys
input = sys.stdin.readline
def dijk(c, result):
    q = []
    heapq.heappush(q, (0, c))
    result[c] = 0
    while q:
        second, now = heapq.heappop(q)
        if second > result[now]:
            continue
        for next, w in g[now]:
            if result[next] > result[now] + w:
                result[next] = result[now] + w
                heapq.heappush(q, (result[next], next))

INF = float('inf')
t = int(input())
for _ in range(t):
    n, d, c = map(int, input().split())
    g = [[] for _ in range(n + 1)]
    for i in range(d):
        a, b, s = map(int, input().split())
        g[b].append((a, s))
    result = [INF] * (n + 1)
    dijk(c, result)
    r = [k for k in result if k!=INF]
    print(len(r), max(r)) # 시간은 최대값