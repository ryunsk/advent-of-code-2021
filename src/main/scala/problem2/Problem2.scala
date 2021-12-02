package problem2

import scala.io.Source
import scala.util.matching.Regex

object Problem2 {
  def solution(filePath: String): Int = {
    val input = readInput(filePath)
    val finalPosition = input.map(parseDepthMeter).foldLeft((0, 0)) { case ((x, y), (a, b)) => (x + a, y + b) }

    finalPosition._1 * finalPosition._2
  }

  private[problem2] def parseDepthMeter(input: String): (Int, Int) = {
    val regexPatternForward: Regex = "forward (\\d+)".r
    val regexPatternUp: Regex = "up (\\d+)".r
    val regexPatternDown: Regex = "down (\\d+)".r

    input match {
      case regexPatternForward(num) => (num.toInt, 0)
      case regexPatternUp(num) => (0, -num.toInt)
      case regexPatternDown(num) => (0, num.toInt)
    }
  }

  private[problem2] def readInput(filePath: String): Array[String] = {
    val lines = Source.fromResource(filePath).getLines()
    lines.toArray
  }
}

object Run {
  def main(args: Array[String]): Unit = {
    val filePath = "input-2"
    println(Problem2.solution(filePath))
  }
}