# Will read entire file into memory
def input_to_lines(input_file):
    with open(input_file) as f:
        lines = f.readlines()
        # Strip whitespace and new lines
        lines = [line.rstrip() for line in lines]
        return lines


def create_diagram(x, y):
    diagram = []
    # Repeat y times to create y coordinates sized board
    for i in range(y):
        # Repeat x times to create x coordinates sized board
        diagram.append([0] * x)
    return diagram


def parse_string_as_coordinates(input_string: str):
    return tuple(int(i) for i in input_string.split(","))


def parse_line(line: str):
    return line.split(" -> ")


def find_all_coordinates(first: tuple, second: tuple):
    if first[0] == second[0]:
        return set((first[0], i) for i in
                   range(min(first[1], second[1]), max(first[1], second[1]) + 1))
    elif first[1] == second[1]:
        return set((i, first[1]) for i in
                   range(min(first[0], second[0]), max(first[0], second[0]) + 1))
    else:
        return {}


def solution_part1(input_file):
    lines = input_to_lines(input_file)
    diagram = create_diagram(1000, 1000)
    total_count = 0
    for line in lines:
        first_coordinates = parse_string_as_coordinates(parse_line(line)[0])
        second_coordinates = parse_string_as_coordinates(parse_line(line)[1])
        for i in find_all_coordinates(first_coordinates, second_coordinates):
            diagram[i[0]][i[1]] += 1
    for i in diagram:
        for j in i:
            if j >= 2:
                total_count += 1

    return total_count


print(solution_part1('input-5'))
