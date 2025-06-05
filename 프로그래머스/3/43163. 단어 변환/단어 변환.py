from collections import defaultdict, deque

def solution(begin, target, words):
    answer = 0
    w = defaultdict(list)
    visit = dict()
    
    for i in words:
        visit[i]=0
        diff = 0
        for k in range(len(i)):
            if i[k]!=begin[k]:
                diff +=1
        if diff==1:
            w[begin].append(i)
            
    for i in range(len(words)):
        for j in range(i+1,len(words)):
            diff = 0
            for k in range(len(words[i])):
                if words[i][k]!=words[j][k]:
                    diff +=1
            if diff==1:
                w[words[i]].append(words[j])
                w[words[j]].append(words[i])
    def bfs(x):
        q = deque()
        q.append((x,0))
        visit[x] = 1
        while q:
            now,cnt = q.popleft()
            if now == target:
                return cnt
            for next in w[now]:
                if visit[next]==0:
                    visit[next]=1
                    q.append((next,cnt+1))    
        return 0  
    return bfs(begin)