a,b = map(int, input().split())
c = a*b
while a%b != 0:
    a,b = b, a%b
print(b) # 최대 공약수
print(c//b) # 최소 공배수 (= 두 자연수 곱/최대 공약수)