package problem4

import scala.io.Source

object Problem4 {
  def solution(filePath: String): Unit = {
    val inputData = readInput(filePath)
    val numbersToDraw = parseInputToNumbersToDraw(inputData)
    val bingoBoards = parseInputToAllBingoBoards(inputData)

    //    println(numbersToDraw.mkString(","))
    //    println(bingoBoards)
    //    def loop():
  }

  private[problem4] def isWinner(board: Array[Array[String]]): Boolean = {
    val horizontal = board.flatMap(_.mkString("")).mkString("")
    val vertical = board.transpose.flatMap(_.mkString("")).mkString("")
    horizontal.contains("XXXXX") || vertical.contains("XXXXX")
  }

  // Check if board has any winners
  private[problem4] def parseInputToNumbersToDraw(input: Array[String]): Array[String] = {
    input.head.split(",")
  }

  private[problem4] def parseInputToAllBingoBoards(input: Array[String]): Array[Array[Array[String]]] = {
    // Array of 2D Boards (Array[Array[Int]])
    input.tail.filter(_ != "").map(parseLineToRow).sliding(5, 5).toArray
  }

  private[problem4] def parseLineToRow(input: String): Array[String] = {
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
