import sys

input = sys.stdin.readline

channel = input()[:-1]
flag = 1
c_list = list(map(int, channel))
tmp = c_list

broken = int(input())
if broken:
    br_lst = map(int, input())
else: br_lst = []


for c in tmp:
    while c in br_lst:
        c += flag
        if c == 0: break


