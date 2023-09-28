def sol(n, a):
    global w, b
    if n == 0:
        return
    one = [r[:n] for r in a[:n]]
    two = [r[n:] for r in a[:n]]
    three = [r[:n] for r in a[n:]]
    four = [r[n:] for r in a[n:]]
    if sum(sum(one,[])) == n*n:
        b+=1
    elif sum(sum(one,[])) == 0:
        w+=1
    else:
        sol(n//2, one)

    if sum(sum(two,[])) == n*n:
        b+=1
    elif sum(sum(two,[])) == 0:
        w+=1
    else:
        sol(n//2, two)

    if sum(sum(three,[])) == n*n:
        b+=1
    elif sum(sum(three,[])) == 0:
        w+=1
    else:
        sol(n//2, three)

    if sum(sum(four,[])) == n*n:
        b+=1
    elif sum(sum(four,[])) == 0:
        w+=1
    else:
        sol(n//2, four)

n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]
w, b = 0, 0
if sum(sum(a,[])) == n*n:
    b+=1
elif sum(sum(a,[])) == 0:
    w+=1
else:
    sol(n//2, a)
print(w)
print(b)