file_path_test = "test.txt"
file_path_input = "input.txt"

dial = 50
zeros = 0
with open(file_path_input, 'r') as file:
    for line in file:
        direction = line[0]
        amount = int (line[1:])
        if direction == 'R':
            dial = (dial + amount) % 100
        else:
            dial = (dial - amount) % 100
        if dial == 0:
            zeros += 1
            print(f"found zero after {direction, amount}")

print(f"Value:  {zeros}")