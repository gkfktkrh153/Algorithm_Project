def solution(picks, minerals):

    answer = 0; info = []
    minerals = minerals[:5 * sum(picks)]

    tiredList = [[1, 1,  1], [5, 1, 1], [25, 5, 1]]
    connectionDict = {"diamond": 0, "iron": 1, "stone": 2}

    while minerals:
        usedDia, usedIron, usedStone = 0, 0, 0
        for _ in range(5):
            mineral = minerals.pop(0)
            usedDia += tiredList[0][connectionDict[mineral]]
            usedIron += tiredList[1][connectionDict[mineral]]
            usedStone += tiredList[2][connectionDict[mineral]]
            if not minerals: break

        info.append([usedDia, usedIron, usedStone])

    info.sort(key=lambda x: [x[2], x[1], x[0]])
    print(info)
    for idx, n in enumerate(picks):
        for _ in range(n):
            if info:
                print(info)
                tmp = info.pop()[idx]
                answer += tmp
                print(tmp)
            else: return answer

    return answer


print(solution([1, 3, 2], ["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]))