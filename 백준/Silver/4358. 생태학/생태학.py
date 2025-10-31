from collections import defaultdict
import sys

line = sys.stdin.read().splitlines() # 입력 전체를 한 번에 읽고 개행 제거
d = defaultdict(int)
cnt = len(line)
for s in line:
    d[s] += 1

for k in sorted(d):
    print(f'{k} {d[k]/cnt*100:.4f}')