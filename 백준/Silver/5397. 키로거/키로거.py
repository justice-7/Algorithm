t = int(input())
for i in range(t):
    s = input()
    st1 = []
    st2 = []
    for j in range(len(s)):
        if s[j]=="<":
            if st1:
                st2.append(st1.pop())
        elif s[j]==">":
            if st2:
                st1.append(st2.pop())
        elif s[j]=="-":
            if st1:
                st1.pop()
        else:
            st1.append(s[j])
    st2.reverse()
    print("".join(st1+st2))