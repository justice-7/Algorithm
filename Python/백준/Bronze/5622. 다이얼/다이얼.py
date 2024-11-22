a = [[0],[1],[2],['A','B','C'], ['D','E','F'], ['G','H','I'], ['J','K','L'], ['M','N','O'], ['P','Q','R','S'], ['T','U','V'], ['W','X','Y','Z']]
s = input()
result = 0
for i in s:
    for j in range(3,11):
        if i in a[j]:
            result+=j
            break
print(result)