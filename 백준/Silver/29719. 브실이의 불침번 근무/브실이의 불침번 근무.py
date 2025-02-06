n,m = map(int, input().split())
all = (m**n) % 1000000007
notBs = ((m-1)**n) % 1000000007
print((all-notBs)%1000000007)