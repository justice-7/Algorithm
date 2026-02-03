import sys
input = sys.stdin.readline
def init(node, start, end):
    if start == end:
        maxTree[node] = ar[start]
        minTree[node] = ar[start]
        return
    mid = start+(end-start)//2
    init(node*2, start, mid)
    init(node*2 + 1, mid+1, end)
    maxTree[node] = max(maxTree[node * 2], maxTree[node * 2 + 1])
    minTree[node] = min(minTree[node * 2], minTree[node * 2 + 1])

def minQuery(node, start, end, left, right):
    if right < start or left > end:
        return float('inf')
    if left<=start and end<=right:
        return minTree[node]
    mid = start+(end-start)//2
    return min(minQuery(node*2,start,mid,left,right),minQuery(node*2+1,mid+1,end,left,right))

def maxQuery(node, start, end, left, right):
    if right < start or left > end:
        return -float('inf')
    if left<=start and end<=right:
        return maxTree[node]
    mid = start+(end-start)//2
    return max(maxQuery(node*2,start,mid,left,right),maxQuery(node*2+1,mid+1,end,left,right))

n,m = map(int, input().split())
ar = [int(input()) for _ in range(n)]
maxTree = [0]*(n*4)
minTree = [0]*(n*4)
init(1,0,n-1)
for _ in range(m):
    a,b = map(int, input().split())
    print(minQuery(1,0,n-1,a-1,b-1),end=" ")
    print(maxQuery(1,0,n-1,a-1,b-1))