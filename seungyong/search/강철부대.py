
from collections import deque


def BFS(destination):
    d[destination] = 0
    visited[destination] = True
    
    queue = deque([(destination, 0)])
    while queue:
        current, distance = queue.popleft()
        #print(current, distance)

        
        for next in m[current]: # 현재 위치에서 갈 수 있는 곳
            if visited[next] == False:
                queue.append([next, distance + 1])
                visited[next] = True
                d[next] = distance + 1
        #print(queue)
        
def solution(n, roads, sources, destination):
    # n지역 수
    # roads 길
    # sources 부대원 위치
    # destination 목적지
    global m
    global visited
    global d
    
    answer = []
    m = [[]for i in range(n+1)]
    d = [-1 for i in range(n+1)]
    for a,b in roads:
        m[a].append(b)
        m[b].append(a)
        
    visited = [False for i in range(n+1)]
    BFS(destination) # 목적지 
    for i in sources:
        answer.append(d[i])
    
    return answer