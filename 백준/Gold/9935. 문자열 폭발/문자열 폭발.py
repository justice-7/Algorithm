import sys
input = sys.stdin.readline
s = input().rstrip()
bomb = input().rstrip()
st = []
for i in range(len(s)):
    st.append(s[i])
    if "".join(st[-len(bomb):]) == bomb: #.join()으로 리스트를 문자열로 변환
        for _ in range(len(bomb)):
            st.pop()
if len(st):
    print(*st, sep="")
else:
    print("FRULA")