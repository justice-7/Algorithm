def sol(cnt,ans):
    global mi,ma
    if cnt == n-1:
        mi = min(mi,ans)
        ma = max(ma,ans)
        return
    for i in range(4):
        if op[i]>0:
            op[i]-=1
            if i==0:
                sol(cnt+1, ans+a[cnt+1])
            elif i==1:
                sol(cnt+1, ans-a[cnt+1])
            elif i==2:
                sol(cnt+1, ans*a[cnt+1])
            elif i==3:
                if ans<0:
                    sol(cnt+1, -(-ans//a[cnt+1]))
                else:
                    sol(cnt+1, ans//a[cnt+1])
            op[i]+=1
        
n = int(input())
a = list(map(int,input().split()))
op = list(map(int, input().split()))
mi = 10**9+1
ma = -10**9+1
sol(0,a[0])
print(ma)
print(mi)