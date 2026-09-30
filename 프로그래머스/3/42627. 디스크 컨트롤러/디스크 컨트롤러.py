import heapq

def solution(jobs):
    answer = 0
    pq = []
    n = len(jobs)
    jobs.sort(key=lambda x:(x[0],x[1]))
    curTime = 0
    cnt = 0
    i = 0
    while cnt <n:
        while i<n and curTime >= jobs[i][0]:
            heapq.heappush(pq,(jobs[i][1], jobs[i][0], i))# 소요시간, 요청시간, 작업번호       
            i+=1
        if pq:
            now = heapq.heappop(pq)
            curTime += now[0]
            answer+= curTime-now[1]
            cnt+=1
        else: 
            curTime = jobs[i][0]
        
    return answer//n
