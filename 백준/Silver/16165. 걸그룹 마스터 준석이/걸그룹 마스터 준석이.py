n,m = map(int,input().split())
team = {}
person = {}
for i in range(n):
    group = input()
    team[group] = []
    for j in range(int(input())):
        name = input()
        team[group].append(name)
        person[name] = group
for i in range(m):
    a = input()
    n = int(input())
    if n==0:
        print(*sorted(team[a]), sep="\n")
    else:
        print(person[a])