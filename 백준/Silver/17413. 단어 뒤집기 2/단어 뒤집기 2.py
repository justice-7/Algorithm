s = input()
st = []
tag = 0
for i in range(len(s)):
    if s[i] == " ":
        while(st):
            print(st.pop(), end="")
        print(" ", end="")
    elif s[i]=="<":
        while(st):
            print(st.pop(), end="")
        tag = 1
        print("<", end="")
    elif s[i]==">":
        tag = 0
        print(">", end="")
    elif tag:
        print(s[i], end="")
    elif not tag:
        st.append(s[i])
while(st):
    print(st.pop(), end="")