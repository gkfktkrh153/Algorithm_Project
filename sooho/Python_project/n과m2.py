import sys

input = sys.stdin.readline

def back():
    if len(rlt) == m:
        print(" ".join(map(str, rlt)))

    for i in range(1, n+1):
        if visit[i] == 0:
            if len(rlt) > 1 and rlt[-1] < i:
                rlt.append(i); visit[i] = 1
                back()
                visit[i] = 0; rlt.pop()
            elif len(rlt) > 0 and rlt[-1] > i:
                continue
            else:
                rlt.append(i); visit[i] = 1
                back()
                visit[i] = 0; rlt.pop()


n,m = map(int, input().split())
rlt = []
visit = [0] * (n+1)

back()
