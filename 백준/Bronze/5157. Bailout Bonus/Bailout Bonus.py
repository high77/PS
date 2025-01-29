import sys
input = sys.stdin.readline


def main():
    T = int(input())

    for tc in range(1, T + 1):
        C, B, n, r = map(int, input().split())


        set_ = input()
        if B>0 : set_ = set(map(int,set_.split()))
        else: set_ = set()

        ans = 0

        for _ in range(n):
            ci, pi = map(int, input().split())
            if ci in set_:
                ans += (pi * r) // 100

        print(f"Data Set {tc}:")
        print(ans)
        print()




if __name__ == "__main__":
    main()
