import sys
input = sys.stdin.readline

max = 123456*2
prime = [1]*(max+1)
prime[0], prime[1] = 0,0
for i in range(2,int(max**0.5)+1):
    if prime[i]==1:
        for j in range(i*i, max+1, i):
            prime[j]=0

while True:
    n = int(input())
    if n==0:
        break
    print(sum(prime[n+1:2*n+1]))