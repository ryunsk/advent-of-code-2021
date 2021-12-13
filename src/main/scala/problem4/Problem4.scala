package problem4

import scala.io.Source

object Problem4 {
  def solution2(filePath: String): Int = {
    val inputData = readInput(filePath)
    val numbersToDraw = parseInputToNumbersToDraw(inputData)
    var bingoBoards = parseInputToAllBingoBoards(inputData)
    var finalScore = 0
    // mark number -> Check if it is winner
    println("All numbers to draw: " + numbersToDraw.mkString(","))

    for (i <- numbersToDraw; j <- bingoBoards) {
      println("Bingo board length = " + bingoBoards.length)
      println("Number drawn = " + i)
      for (k <- j) {
        if (k.contains(i)) {
          k(k.indexOf(i)) = "X"
        }
        println("Current board row after marking X = " + k.mkString(","))
      }
      if (isWinner(j)) {
        bingoBoards = bingoBoards.filter(x => !(x sameElements j))
        finalScore = calculateFinalScore(j, i.toInt)
      }
    }
    finalScore
  }

  def solution(filePath: String): Int = {
    val inputData = readInput(filePath)
    val numbersToDraw = parseInputToNumbersToDraw(inputData)
    val bingoBoards = parseInputToAllBingoBoards(inputData)
    // mark number -> Check if it is winner
    println("All numbers to draw: " + numbersToDraw.mkString(","))

    for (i <- numbersToDraw; j <- bingoBoards) {
      //      println("Number drawn = " + i)
      for (k <- j) {
        if (k.contains(i)) {
          k(k.indexOf(i)) = "X"
        }
        //        println("Current board row after marking X = " + k.mkString(","))
      }
      if (isWinner(j)) {
        //        println("=====Winner found =====")
        return calculateFinalScore(j, i.toInt)
      }
    }
    -1
  }

  private[problem4] def calculateFinalScore(board: Array[Array[String]], number: Int): Int = {
    val sumOfRest = board.flatten.filter(_ != "X").map(_.toInt).sum
    sumOfRest * number
  }

  private[problem4] def isWinner(board: Array[Array[String]]): Boolean = {
    val horizontal = board.map(_.mkString("")).map(_.contains("XXXXX"))
    val vertical = board.transpose.map(_.mkString("")).map(_.contains("XXXXX"))
    horizontal.contains(true) || vertical.contains(true)
  }

  private[problem4] def parseInputToNumbersToDraw(input: Array[String]): Array[String] = {
    input.head.split(",")
  }

  private[problem4] def parseInputToAllBingoBoards(input: Array[String]): Array[Array[Array[String]]] = {
    // Array of 2D Boards (Array[Array[Int]])
    input.tail.filter(_ != "").map(parseInputLineToRow).sliding(5, 5).toArray
  }

  private[problem4] def parseInputLineToRow(input: String): Array[String] = {
    if (input.head.toString.equals(" ")) {
      input.tail.replace("  ", " ").split(" ")
    }
    else {
      input.replace("  ", " ").split(" ")
    }
  }

  private[problem4] def readInput(filePath: String): Array[String] = {
    val lines = Source.fromResource(filePath).getLines()
    lines.toArray
  }

}
