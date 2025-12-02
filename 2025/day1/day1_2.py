file_path_test = "test.txt"
file_path_input = "input.txt"

dial = 50
zeros = 0
with open(file_path_input, 'r') as file:
    for line in file:
        direction = line[0]
        amount = int (line[1:])
        full_circle = int (amount / 100)
        zeros += full_circle
        amount = amount % 100
        if direction == 'R':
            val = (dial + amount)
            if val > 100:
                zeros += 1  
                print(f"found zero after {direction, amount}")
            dial = val % 100
        else:
            val = (dial - amount)
            if val < 0 and dial != 0:
                zeros += 1
                print(f"found zero after {direction, amount}")
            dial = val % 100
        if dial == 0:
            zeros += 1
            print(f"found zero after {direction, amount}")

print(f"Value:  {zeros}")