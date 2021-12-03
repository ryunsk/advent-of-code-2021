package problem3

import scala.io.Source

object Problem3 {
  def solution(filePath: String): Int = {
    val input = readInput(filePath)
    convertBinaryToDecimal(findGammaRate(input)) * convertBinaryToDecimal(findEpsilonRate(input))
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

  private[problem3] def findMostCommonElementInCollection[A](coll: Seq[A]): A = {
    coll.groupBy(identity).view.mapValues(_.size).maxBy(_._2)._1
  }

  private[problem3] def findLeastCommonElementInCollection[A](coll: Seq[A]): A = {
    coll.groupBy(identity).view.mapValues(_.size).minBy(_._2)._1
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
  }
}