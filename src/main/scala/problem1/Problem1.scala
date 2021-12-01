package problem1

import scala.io.Source

object Problem1 {


  def solution(input: Array[Int]): Int = {
    val intermediateArray = input.sliding(3, 1).map(x => x.sum).toArray
    compareTwoNumbersInArray(intermediateArray)
  }

  def compareTwoNumbersInArray(input: Array[Int]): Int = {
    input.zip(input.tail).count(x => x._2 > x._1)
  }

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

  private[problem1] def readInput(filePath: String): Array[Int] = {
    val lines = Source.fromResource(filePath).getLines()
    lines.map(_.toInt).toArray
  }
}

object run {
  def main(args: Array[String]): Unit = {
    val f = Problem1.readInput("input-1")
    println(Problem1.compareTwoNumbersInArray(f))
    println(Problem1.solution(f))

  }
}