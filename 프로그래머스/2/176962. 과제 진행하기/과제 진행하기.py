def solution(plans):
    answer = []
    remain = []
    plans = sorted(plans, key = lambda x:x[1])
    for j in range(len(plans)):
        plans[j][2] = int(plans[j][2])
        
    for i in range(1, len(plans)):
        diff = timediff(plans[i-1][1], plans[i][1])
        if (diff >= plans[i-1][2]):
            answer.append(plans[i-1][0])
            diff -= plans[i-1][2]
            while diff>0 and remain:
                if remain[-1][1]<=diff:
                    diff -= remain[-1][1]
                    answer.append(remain.pop()[0])
                else:
                    remain[-1][1] -= diff
                    break
        else:
            remain.append([plans[i-1][0], plans[i-1][2]-diff])
            
    answer.append(plans[-1][0])
    answer.extend(map(lambda x: x[0], reversed(remain)))
        
    return answer

def timediff(start, end):
    sh,sm = map(int, start.split(":"))
    eh,em = map(int, end.split(":"))
    return (eh*60+em) - (sh*60+sm)
