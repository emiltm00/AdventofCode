file_path_test = '2024/day5/star2/test.txt'
file_path_input = '2024/day5/star2/input.txt'

with open(file_path_input, 'r') as file:
    data = file.read().splitlines()

"""
Spara alla regler i en dict, 
där key är värdet som borde komma efter värdena i value listan.
"""
rules: dict = {}
page_updates: list[list[int]] = []
for line in data:
    if '|' in line:
        in_data: list[str] = line.split('|')
        key: int = int(in_data[1])
        value: int = int(in_data[0])
        if key not in rules:
            rules[key] = []
        rules[key].append(value)
    elif line != '':
        page_updates.append(list(map(int, line.split(','))))


def fix_update(update: list[int]) -> int:
    temp_update = update.copy()
    fix_update = False
    for page in temp_update:
        ruls = rules.get(page)
        if ruls != None:
            this_index = temp_update.index(page)
            last_index = -1
            for rul in temp_update:
                if rul in ruls:
                    last_index = temp_update.index(rul)
            if this_index < last_index:
                temp_update[this_index], temp_update[last_index] = temp_update[last_index], temp_update[this_index]
                fix_update = True
    if fix_update:
        return temp_update[len(temp_update)//2]
    else:
        return None
                
sum = 0
for update in page_updates:
    value = fix_update(update)
    print(value)
    if value != None:
        sum += value

print(sum)
# borde bli 4655

# [71, 15, 39, 83, 59, 17, 37, 34, 62, 11, 28, 75, 16, 69, 85, 58, 43, 68, 33]
# [15, 83, 59, 17, 37, 34, 62, 11, 28, 75, 16, 69, 85, 58, 43, 68, 33, 71, 39]