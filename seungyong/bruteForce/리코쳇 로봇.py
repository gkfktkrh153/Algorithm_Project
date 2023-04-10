from collections import deque
dY = [-1,0,1,0]
dX = [0,1,0,-1]

def BFS(start):
    queue = deque([start])
    stop = -1
    while(queue):
        y, x, distance =  queue.popleft()

        #print(y,x)
        if m[y][x] == 'G':
            return distance

        
        for i in range(4):
            nY = y
            nX = x
            while(True):
                if 0 <= nY + dY[i] <row and 0 <= nX + dX[i] < col: # 다음 이동할 곳이 범위 내
                    if m[nY + dY[i]][nX + dX[i]] == 'D': # 갈 수 없는 곳 
                        if visited[nY][nX] == False: # 현재 위치가 방문 안한 곳
                            queue.append((nY, nX, distance + 1))
                            visited[nY][nX] = True
                            break
                        else:
                            break
                    else: # 갈 수 있는 곳
                        nY += dY[i]
                        nX += dX[i]   
                else: # 갈 수 없는 곳
                    if visited[nY][nX] == False: # 현재 위치가 방문 안한 곳
                        queue.append((nY, nX, distance + 1))
                        visited[nY][nX] = True
                        break
                    else: 
                        break
    return -1   
                        
                            
                            
def solution(board):
    # 격자모양 게임판 위에서 말을 움직이는 게임
    # 시작 위치R에서 목적지G까지 장애물D를 피해 도착할 때까지의 최소시간
    # G에 도착한다면 이동횟수 리턴
    global m
    global row
    global col
    global visited
    
    m = []
    row = len(board)
    col = len(board[0])
    visited = [[False for i in range(col)] for j in range(row)]
    for i in board:
        m.append(list(i))
        
    for i in range(row):
        for j in range(col):
            if m[i][j] == 'R':
                visited[i][j] = True
                answer = BFS((i,j,0))

    return answer