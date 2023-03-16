# 모든 기준점에서의 탐색은 가장 먼 곳 까지의 길이를 가짐
# 그 중에서 가장 먼 곳의 길이를 구하면 됨
from collections import deque
N, M = map(int, input().split())
visited = []
dy = [-1,0,1,0]
dx = [0,1,0,-1]
max_distance = 0
def BFS(start):
    global max_distance
    y, x = start
    visited[y][x] = 'X'

    dq = deque([(y,x,0)])
    while(dq):
        y,x, distance = dq.popleft()
        #print(y,x,distance)
        if max_distance < distance:
            max_distance = distance
        for i in range(4):
            nextY = dy[i] + y
            nextX = dx[i] + x
            if 0 <= nextY < N and 0 <= nextX < M and visited[nextY][nextX] == 'O': # 범위 내
                visited[nextY][nextX] = 'X'
                dq.append((nextY,nextX,distance + 1))

def init_map():
    global visited
    visited = []
    for i in range(N):
      l = []
      for j in range(M):
          if m[i][j] == 'W':
              l.append('X')
          else:
              l.append('O')
      visited.append(l)



m = []
for i in range(N):
    r = list(input())
    m.append(r)
        
init_map()

for i in range(N):
    for j in range(M):
        if m[i][j] == 'L': # 육지라면
          #print('-----------------------시작점', i,j,'----------------------')
          init_map()
          #print(visited)
          BFS((i,j))

print(max_distance)