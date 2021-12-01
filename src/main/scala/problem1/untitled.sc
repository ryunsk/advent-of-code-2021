val a = Array(1, 2, 3) // returns 2

val b = Array(1, 5, 3, 2, 3, 4) // return 3

val c = List(1, 2, 3, 4, 5, 1, 2) // return 5

a.zip(a.tail) // zip between 1,2,3 and 2,3

a.zip(a.tail).count(x => x._2 > x._1)

b.sliding(3, 1).toArray

def oldSolution(input: Array[Int]): Int = {
  // Imperative style with for loops.
  // more functional style using .zip and .count
  var count = 0
  for (i <- 1 until input.length) {
    if (input(i) > input(i - 1)) {
      count += 1
    }
  }
  count
}