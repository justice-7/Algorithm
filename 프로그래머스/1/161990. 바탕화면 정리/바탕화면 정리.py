def solution(wallpaper):
    maR, maC = -1,-1
    miR,miC = 500,500
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] == "#":
                miR = min(miR, i)
                miC = min(miC, j)
                maR = max(maR, i)
                maC = max(maC, j)
                
                
    answer = [miR,miC,maR+1,maC+1]
    return answer