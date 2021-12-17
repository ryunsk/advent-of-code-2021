import unittest

from Day5 import parse_line
from Day5 import parse_string_as_coordinates
from Day5 import find_all_coordinates


class TestDay5(unittest.TestCase):
    def test_parsing_coordinates(self):
        self.assertEqual(parse_string_as_coordinates("0,9"), (0, 9))

    def test_parsing_line(self):
        self.assertEqual(parse_line("0,9 -> 5,9"), ['0,9', '5,9'], "coordinates should be parsed correctly")

    def test_find_all_coordinates_1(self):
        self.assertEqual(find_all_coordinates((1, 1), (1, 3)), {(1, 1), (1, 2), (1, 3)})

    def test_find_all_coordinates_2(self):
        self.assertEqual(find_all_coordinates((9, 7), (7, 7)), {(9, 7), (8, 7), (7, 7)})

    def test_find_all_coordinates_3(self):
        self.assertEqual(find_all_coordinates((0, 9), (5, 9)), {(0, 9), (1, 9), (2, 9), (3, 9), (4, 9), (5, 9)})


if __name__ == '__main__':
    unittest.main()
