val a = Array(1, 2, 3) // returns 2

val b = Array(1, 5, 3, 2, 3, 4) // return 3

val c = List(1, 2, 3, 4, 5, 1, 2) // return 5

a.zip(a.tail) // zip between 1,2,3 and 2,3

a.zip(a.tail).count(x => x._2 > x._1)