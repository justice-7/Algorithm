color=["black","brown","red","orange","yellow","green","blue","violet","grey","white"]
a = [input() for _ in range(3)]
result = 0
result += int(color.index(a[0]))*10 + int(color.index(a[1]))
result *= 10**(int(color.index(a[2])))
print(result)