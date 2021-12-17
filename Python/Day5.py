# Will read entire file into memory
def input_to_lines(input_file):
    with open(input_file) as f:
        lines = f.readlines()
        # Strip whitespace and new lines
        lines = [line.rstrip() for line in lines]
        return lines


def create_diagram():
    diagram = []
    for i in range(9):
        diagram.append([0, 0, 0, 0, 0, 0, 0, 0, 0])
    return diagram


def parse_string_as_coordinates(input_string: str):
    return tuple(int(i) for i in input_string.split(","))


def parse_line(line: str):
    return line.split(" -> ")


def find_all_coordinates(first: tuple, second: tuple):
    if first[0] == second[0]:
        return list((first[0], i) for i in range(first[1], first[1] + abs(second[1] - first[1])))
    else:
        return list((i, first[1]) for i in range(first[0], first[0] + abs(second[0] - first[0] + 1)))


def solution_part1():
    diagram = create_diagram()

# print(input_to_lines("input-5-test"))
# print(create_diagram())
# print(find_all_coordinates((0, 9), (5, 9)))
# print(parse_string_as_coordinates("0,9"))
# print(parse_line("0,9 -> 2,9"))
# print(find_all_coordinates((9, 7), (7, 7)))
