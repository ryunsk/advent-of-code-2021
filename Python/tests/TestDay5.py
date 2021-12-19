import unittest

from Day5 import parse_line, solution_part1, create_diagram
from Day5 import parse_string_as_coordinates
from Day5 import find_all_coordinates


class TestDay5(unittest.TestCase):
    def test_create_diagram(self):
        self.assertEqual(create_diagram(2, 2), [[0, 0], [0, 0]])

    def test_parsing_coordinates(self):
        self.assertEqual(parse_string_as_coordinates("0,9"), (0, 9))

    def test_parsing_line(self):
        self.assertEqual(parse_line("0,9 -> 5,9"), ['0,9', '5,9'], "multiple coordinates should be parsed correctly")

    def test_parsing_string_as_coordinates(self):
        self.assertEqual(parse_string_as_coordinates("0,9"), (0, 9), "coordinates should be parsed correctly to tuples")

    def test_find_all_coordinates_1(self):
        self.assertEqual(find_all_coordinates((1, 1), (1, 3)), {(1, 1), (1, 2), (1, 3)})

    def test_find_all_coordinates_2(self):
        self.assertEqual(find_all_coordinates((9, 7), (7, 7)), {(9, 7), (8, 7), (7, 7)})

    def test_find_all_coordinates_3(self):
        self.assertEqual(find_all_coordinates((0, 9), (5, 9)), {(0, 9), (1, 9), (2, 9), (3, 9), (4, 9), (5, 9)})

    def test_find_all_coordinates_4(self):
        self.assertEqual(find_all_coordinates((6, 4), (2, 0)),
                         {}), "Should return empty set for coordinates x1!=x2 or y1!=y2"

    def test_find_all_coordinates_5(self):
        self.assertEqual(find_all_coordinates((1, 0), (3, 0)),
                         {(1, 0), (2, 0), (3, 0)}), "Should not get larger number for difference"

    def test_find_all_coordinates_6(self):
        self.assertEqual(find_all_coordinates((2, 2), (2, 1)),
                         {(2, 1), (2, 2)}), "Should not get larger number for difference"

    def test_solution_part1(self):
        self.assertEqual(solution_part1("input-5-test"), 5)


if __name__ == '__main__':
    unittest.main()
