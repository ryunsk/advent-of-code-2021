package problem4

import scala.io.Source

object Problem4 {
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
        val sumOfRest = j.flatten.filter(_ != "X").map(_.toInt).sum
        val result = sumOfRest * i.toInt
        return result
      }
    }
    -1
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
