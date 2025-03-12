import sys
input = sys.stdin.readline

N = int(input())
A, B = map(int, input().split())
set_ = set(tuple(map(int, input().split())) for _ in range(N))

ans = 0
for x,y in set_:
    if ((x+A,y) in set_) and ((x,y+B) in set_) and ((x+A,y+B) in set_):
        ans += 1

print(ans)