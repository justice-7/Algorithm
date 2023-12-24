x1,x2 = map(int, input().split())
a,b,c,d,e = map(int, input().split())
b-=d
c-=e
a//=3
b//=2
fir = a*x2**3+b*x2**2+c*x2
sec = a*x1**3+b*x1**2+c*x1
print(fir-sec)