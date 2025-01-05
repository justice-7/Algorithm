def comb(cnt,start):
    if cnt == l:
        m = 0
        for a in result:
            if a in ['a','e','i','o','u']:
                m+=1
        if m>=1 and l-m>=2:
            print(*result,sep="")
        return 
    for i in range(start,c):
        result[cnt]=al[i]
        comb(cnt+1, i+1)
        
l,c = map(int, input().split())
al = input().split()
al.sort()
result = [0]*l
comb(0,0)