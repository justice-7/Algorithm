from collections import defaultdict
import heapq
def solution(genres, plays):
    answer = []
    g = defaultdict(int)
    for i in range(len(genres)):
        g[genres[i]] += plays[i]
    g = sorted(g.items(), key=lambda x:-x[1])
    p = defaultdict(list)
    for i in range(len(genres)):
        heapq.heappush(p[genres[i]],(-plays[i],i))
    for j in range(len(g)):
        for k in range(min(2,len(p[g[j][0]]))):
            answer.append(heapq.heappop(p[g[j][0]])[1])
    return answer