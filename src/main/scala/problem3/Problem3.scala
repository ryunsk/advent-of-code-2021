package problem3

import scala.annotation.tailrec
import scala.io.Source

object Problem3 {
  case class BitOccurrence(value: Char, count: Int)

  def solution(filePath: String): Int = {
    val input = readInput(filePath)
    convertBinaryToDecimal(findGammaRate(input)) * convertBinaryToDecimal(findEpsilonRate(input))
  }

  def solutionPartTwo(filePath: String): Int = {
    val input = readInput(filePath)
    convertBinaryToDecimal(findLastRemainingOxygenBitCriteria(input)) * convertBinaryToDecimal(findLastRemainingCO2BitCriteria(input))
  }

  def findLastRemainingOxygenBitCriteria(input: List[String]): String = {
    @annotation.tailrec
    def loop(index: Int, inputList: List[String]): String = {
      if (inputList.length == 1) {
        inputList.head
      } else {
        val transposedList = inputList.transpose
        val mostCommonCharInIndex = findMostCommonElementInCollection(transposedList(index))
        val filtered = inputList.filter(x => x(index) == mostCommonCharInIndex)
        loop(index + 1, filtered)
      }
    }

    loop(0, input)
  }

  def findLastRemainingCO2BitCriteria(input: List[String]): String = {
    @annotation.tailrec
    def loop(index: Int, inputList: List[String]): String = {
      if (inputList.length == 1) {
        inputList.head
      } else {
        val transposedList = inputList.transpose
        val leastCommonCharInIndex = findLeastCommonElementInCollection(transposedList(index))
        val filtered = inputList.filter(x => x(index) == leastCommonCharInIndex)
        loop(index + 1, filtered)
      }
    }

    loop(0, input)
  }

  def findGammaRate(input: List[String]): String = {
    input.transpose.map(findMostCommonElementInCollection).mkString
  }

  def findEpsilonRate(input: List[String]): String = {
    input.transpose.map(findLeastCommonElementInCollection).mkString
  }

  def convertBinaryToDecimal(binaryNumber: String): Int = {
    Integer.parseInt(binaryNumber, 2)
  }

  private[problem3] def findMostCommonElementInCollection(coll: List[Char]): Char = {
    val intermediate = coll.groupBy(identity).view.mapValues(_.size).map(x => BitOccurrence(x._1, x._2)).toList
    if (intermediate.head.count == intermediate(1).count) {
      '1'
    } else {
      intermediate.maxBy(_.count).value
    }
  }

  private[problem3] def findLeastCommonElementInCollection(coll: List[Char]): Char = {
    val intermediate = coll.groupBy(identity).view.mapValues(_.size).map(x => BitOccurrence(x._1, x._2)).toList
    if (intermediate.head.count == intermediate(1).count) {
      '0'
    } else {
      intermediate.minBy(_.count).value
    }
  }

  private[problem3] def readInput(filePath: String): List[String] = {
    val lines = Source.fromResource(filePath).getLines()
    lines.toList
  }
}

object run {
  def main(args: Array[String]): Unit = {
    val filePath = "input-3"
    println(Problem3.solution(filePath))
    println(Problem3.solutionPartTwo(filePath))
  }
}