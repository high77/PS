import sys

digit_patterns = [
    "####.##.##.####",
    "..#..#..#..#..#",
    "###..#####..###",
    "###..####..####",
    "#.##.####..#..#",
    "####..###..####",
    "####..####.####",
    "###..#..#..#..#",
    "####.#####.####",
    "####.####..####"
]


def match(x, k, input_grid):
    for i in range(5):
        for j in range(3):
            if input_grid[i][x + j] == "#" and digit_patterns[k][i * 3 + j] == ".":
                return False
    return True


def main():
    input_grid = [sys.stdin.readline().strip() for _ in range(5)]
    timer = [2, 9, 5, 9]

    for x in range(4):
        for k in range(timer[x] + 1):
            if match(4 * x, k, input_grid):
                print(k, end="")
                break
        if x == 1:
            print(":", end="")
    print()


if __name__ == "__main__":
    main()
