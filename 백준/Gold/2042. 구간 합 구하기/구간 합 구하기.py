import sys
input = sys.stdin.readline

def init(node, start, end):
    global tree
    if start==end:
        tree[node] = arr[start]
        return
    mid = start+(end-start)//2
    init(node*2, start,mid)
    init(node*2+1, mid+1, end)
    tree[node] = tree[node*2]+tree[node*2+1]

def update(node, start, end, ind, value):
    global tree
    if ind < start or end < ind:
        return
    if start == end:
        tree[node] = value
        return
    mid = start + (end - start) // 2
    if ind <= mid:
        update(node * 2, start, mid, ind, value)
    else:
        update(node * 2 + 1, mid + 1, end, ind, value)
    tree[node] = tree[node*2]+tree[node*2+1]

# left, right: 합을 구하고자 하는 구간
def query(node, start, end, left, right):
    if left>end or right<start:
        return 0
    if left<=start and end<=right:
        return tree[node]
    mid = start + (end - start) // 2
    return query(node*2, start, mid, left, right)+query(node*2+1, mid+1, end, left,right)


n,m,k = map(int, input().split())
arr = [int(input()) for _ in range(n)]

tree=[0]*(4*n)
init(1,0,n-1)
for j in range(m+k):
    a,b,c = map(int, input().split())
    if a == 1:
        update(1,0,n-1,b-1,c)
    elif a == 2:
        print(query(1,0,n-1,b-1,c-1))