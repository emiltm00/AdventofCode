file_path_test = '2024/day5/star1/test.txt'
file_path_input = '2024/day5/star1/input.txt'

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

sum = 0
for updates in page_updates:
    for i,number in enumerate(updates):
        temp_list: list[int] = updates[i+1:] 
        rule_list: list[int] = rules.get(number)
        if rule_list != None:
            for rule in rule_list:
                if rule in temp_list:
                    updates.clear()
                    break
    if len(updates) > 0:                  
        sum += updates[len(updates)//2]

print(sum)