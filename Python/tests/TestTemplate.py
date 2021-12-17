import unittest


class TestTemplate(unittest.TestCase):

    def test_template(self):
        self.assertEquals([1, 2, 3], [1, 2, 3], "Should be the same")
        self.assertEquals([[1, 2], [3, 4]], [[1, 2], [3, 4]], "Should be the same")

        self.assertNotEquals([[1, 2], [3, 4]], [[1, 2], [1, 1]], "Should not be the same")

    def test_sum(self):
        assert sum([1, 2, 3]) == 6, "Should be 6"

    def test_sum_tuple(self):
        assert sum((1, 2, 3)) == 6, "Should be 6"


if __name__ == '__main__':
    unittest.main()
