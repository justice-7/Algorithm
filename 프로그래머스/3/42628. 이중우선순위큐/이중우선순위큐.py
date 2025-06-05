import heapq
def solution(operations):
    min=[]
    max=[]
    visit = dict()
    for ind,op in enumerate(operations):
        command, value = op.split(" ")
        value = int(value)
        if command == 'I':
            heapq.heappush(min,(value,ind))
            heapq.heappush(max,(-value,ind))
            visit[ind]=1
        elif value == 1:
            while max and visit.get(max[0][1])==0:
                heapq.heappop(max)
            if max:
                visit[heapq.heappop(max)[1]]=0
        elif value ==-1:
            while min and visit.get(min[0][1])==0:
                heapq.heappop(min)
            if min:
                visit[heapq.heappop(min)[1]]=0
    while max and visit.get(max[0][1])==0:
                heapq.heappop(max)
    while min and visit.get(min[0][1])==0:
                heapq.heappop(min)
    return [0,0] if not min or not max else [-heapq.heappop(max)[0], heapq.heappop(min)[0]]