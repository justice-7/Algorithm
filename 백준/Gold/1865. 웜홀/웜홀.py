import sys
input = sys.stdin.readline

def bellmanFord(start):
    dist = [100000000]*(n+1)
    dist[start] = 0
    for i in range(n):
        for now,next,w in edge:
            if dist[next] > dist[now]+w:
                dist[next] = dist[now]+w
                if i==n-1:
                    return "YES"
    return "NO"

tc = int(input())
for _ in range(tc):
    n,m,w = map(int, input().split())
    edge = []
    for i in range(m):
        s,e,t = map(int, input().split())
        edge.append((s,e,t))
        edge.append((e,s,t))
    for j in range(w):
        s,e,t = map(int, input().split())
        edge.append((s,e,-t))
    print(bellmanFord(1))