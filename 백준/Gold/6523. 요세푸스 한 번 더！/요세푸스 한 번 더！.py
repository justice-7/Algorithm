while True:
    s = list(map(int, input().split()))
    if (s[0] == 0):
        break
    n = s[0]
    a = s[1]
    b = s[2]
    x=0
    no=0
    dic = {}
    while (True):
        if (x in dic):
            dic[x]+=1
            if dic[x]==2:
                no+=1
            if dic[x]==3:
                break
        else:
            dic[x]=1
        x = ((a*((x*x)%n))%n+b)%n
    print(n-no)