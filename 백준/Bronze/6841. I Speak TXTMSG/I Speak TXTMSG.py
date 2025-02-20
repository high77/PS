import sys
input = sys.stdin.readline



def main():
    trans = {"CU":"see you",":-)":"I’m happy",":-(":"I’m unhappy",
             ";-)":"wink",":-P":"stick out my tongue","(~.~)":"sleepy",
             "TA":"totally awesome","CCC":"Canadian Computing Competition",
             "CUZ":"because","TY":"thank-you","YW":"you’re welcome","TTYL":"talk to you later"}
    while True:
        S = input().rstrip()
        print(trans.get(S,S))
        if S == "TTYL":
            break


if __name__ == "__main__":
    main()
