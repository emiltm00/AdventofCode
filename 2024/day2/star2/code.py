file_path_test = "/home/emil/AdventofCode/2024/day2/star2/test.txt"
file_path_input = "/home/emil/AdventofCode/2024/day2/star2/input.txt"

def testLevels(levelsTest) -> bool:
    prev_val = None
    prev_diff = 0
    safe = True
    for x in levelsTest:
        if prev_val == None:
            prev_val = x
            continue
        diff = x - prev_val
        if prev_diff < 0 and diff > 0 or prev_diff > 0 and diff < 0 :
            safe = False
            break
        if not 1 <= abs(diff) <= 3:
            safe = False
            break
        prev_val = x
        prev_diff = diff
    if safe:
        return True
     
def testSwitchedLevels(levelList):
    originalLevels = levelList[:]
    for i in (range(len(levelList))):
        levelList = levelList[:i] + levelList[i+1:]
        if testLevels(levelList) :
            return True
        levelList = originalLevels[:]



sum = 0
with open(file_path_input,"r") as file:
    for report in file.readlines():
        levels = [int(val) for val in report.split(" ")] 
        if not testLevels(levels):
            if testSwitchedLevels(levels): 
                sum += 1
        if testLevels(levels) :
            sum += 1

print(f"{sum = }")