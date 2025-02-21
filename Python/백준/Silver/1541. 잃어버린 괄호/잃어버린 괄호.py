s = input().split("-")
result = [sum(map(int, i.split("+"))) for i in s]
print(result[0]-sum(result[1:]))