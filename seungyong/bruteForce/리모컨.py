from itertools import product
sets = ['0','1','2','3','4','5','6','7','8','9']

dest = int(input())
n = int(input())
if n > 0:
  exclude = list(input().split())
  for e in exclude: # 버튼 제외
   sets.remove(e)

result = abs(100 - dest) # 현재 채널인 100에서 목적지까지의 거리



# 모든 경우의 수를 탐색
for i in range(1,7):
  data = product(sets, repeat = i) 
  for d in data: ##  111111(자리수) + distance
    distance =  abs(int(''.join(d)) - dest) # 목적지까지의 거리
    print(d, distance, abs(int(''.join(d)) - dest))
    for i in d: # 자리수 더하기  
      distance += 1


    
    if result > distance:
      result = distance
print(result) 