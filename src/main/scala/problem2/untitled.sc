val a = Array((1, 0), (2, 3))

a.foldLeft((0, 0)) { case ((x, y), (a, b)) => (x + a, y + b) }