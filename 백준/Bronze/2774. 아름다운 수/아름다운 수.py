import sys
input = sys.stdin.readline

def main():
    T = int(input())
    for _ in range(T):
        set_ = set(input().rstrip())
        print(len(set_))
main()