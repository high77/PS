import sys
input = sys.stdin.readline


def main():
    R, C = map(int, input().split())
    card = [list(input().strip()) for _ in range(R)]
    A, B = map(int, input().split())

    for i in range(R):
        card[i] += reversed(card[i])

    card+=reversed([row[:] for row in card])

    card[A - 1][B - 1] = '.' if card[A - 1][B - 1] == '#' else '#'

    for row in card:
        print("".join(row))


if __name__ == "__main__":
    main()
