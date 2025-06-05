import heapq
def solution(operations):
    min=[]
    max=[]
    for op in operations:
        command, value = op.split(" ")
        value = int(value)
        if command == 'I':
            heapq.heappush(min,value)
            heapq.heappush(max,-value)
        elif max and value == 1:
            min.remove(-heapq.heappop(max))
        elif min and value ==-1:
            max.remove(-heapq.heappop(min))
               
    return [0,0] if not max else [-heapq.heappop(max),heapq.heappop(min)]