import sys
input = sys.stdin.readline



def main():
    N = 8  # 참가자 수
    arr = [[0] * N for _ in range(N)]
    list_ = list(map(int, input().split()))
    idx = 0
    for i in range(7):
        for j in range(i + 1, N):
            arr[i][j] = list_[idx]
            arr[j][i] = 100 - arr[i][j]
            idx += 1

    dp = [[1.0] * N] + [[0.0] * N for _ in range(3)]

    for r in range(1, 4):
        block_size = 1 << r
        for i in range(N):
            block_start = (i // block_size) * block_size
            block_mid = block_start + block_size // 2
            block_end = block_start + block_size

            s, e = (block_mid, block_end) if i < block_mid else (block_start, block_mid)

            dp[r][i] = sum(dp[r - 1][i] * dp[r - 1][j] * (arr[i][j] / 100) for j in range(s, e))
    print(*dp[3])

if __name__ == "__main__":
    main()
