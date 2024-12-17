import re

file_path_input = "2024/day4/star1/input.txt"
file_path_test = "2024/day4/star1/test.txt"
with open(file_path_input, 'r') as file:
    input = file.readlines()
input = [line.strip('\n') for line in input]

"""
Find diagonals by shifting the lines to make diagonals vertical,
    adding '.' to each side to make this possible.

    |A| B C    . . |A| B C        
    D |E| F -> . D |E| F .
    G H |I|    G H |I| . .
"""
diagonal_right= [
    '.' * (len(input) - 1 - i) + line + '.' * i
    for i, line in enumerate(input)
]
diagonal_left= [
    '.' * i + line + '.' * (len(input) - 1 - i)
    for i, line in enumerate(input)
]

def get_vertical(m: list) -> list:
    """
    Return a list with strings of the verticals of the input
    """
    return_list = []
    for col in range(len(m[len(m)-1])):
        temp_list = ''
        for line in range(len(m)):
            temp_list = temp_list + (m[line][col])
        return_list.append(temp_list)
    return return_list

def search(m: list) -> int:
    """
    Searches the list for XMAS, SAMX
    Returns int of how many occurances
    """
    temp_sum=0
    for line in m:
       temp_sum += len(re.findall(r'(?=XMAS)|(?=SAMX)',line))
    return temp_sum

vertical_input = get_vertical(input)
vertical_diagonal_right = get_vertical(diagonal_right)
vertical_diagonal_left = get_vertical(diagonal_left)

total_sum = search(input) + search(vertical_input) + search(vertical_diagonal_right) + search(vertical_diagonal_left) 
print(f'{total_sum = }')