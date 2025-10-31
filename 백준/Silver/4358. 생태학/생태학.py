from collections import defaultdict
import sys

input = sys.stdin.readline

d = defaultdict(int)
cnt = 0
while True:
    s = input().strip()
    if not s:
        break # EOF 도달 시 빈 문자열 반환
    d[s] += 1
    cnt+=1

for k, v in sorted(d.items()):
    print(f'{k} {v/cnt*100:.4f}')