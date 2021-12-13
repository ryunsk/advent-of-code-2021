package problem4

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem4Test extends AnyFlatSpec with Matchers {
  behavior of "file parser - input to numbers and board"
  it should "parse random numbers correctly" in {
    val filePath = "test-input-4"
    val inputArray = Problem4.readInput(filePath)
    Problem4.parseInputToNumbersToDraw(inputArray) should equal(
      Array(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1).map(_.toString)
    )
  }

  it should "parse string line into array - 1" in {
    val line = "22 13 17 11  0"
    Problem4.parseInputLineToRow(line) should equal(Array("22", "13", "17", "11", "0"))
  }

  it should "parse string line into array - 2" in {
    val line = " 8  2 23  4 24"
    Problem4.parseInputLineToRow(line) should equal(Array("8", "2", "23", "4", "24"))
  }

  it should "parse all boards from input correctly" in {
    val filePath = "test-input-4"
    val inputArray = Problem4.readInput(filePath)
    val allBoards = Problem4.parseInputToAllBingoBoards(inputArray)
    val expectedBoard1 = Array(
      Array(22, 13, 17, 11, 0),
      Array(8, 2, 23, 4, 24),
      Array(21, 9, 14, 16, 7),
      Array(6, 10, 3, 18, 5),
      Array(1, 12, 20, 15, 19)
    ).map(_.map(_.toString))
    val expectedBoard2 = Array(
      Array(3, 15, 0, 2, 22),
      Array(9, 18, 13, 17, 5),
      Array(19, 8, 7, 25, 23),
      Array(20, 11, 10, 24, 4),
      Array(14, 21, 16, 12, 6)
    ).map(_.map(_.toString))
    val expectedBoard3 = Array(
      Array(14, 21, 17, 24, 4),
      Array(10, 16, 15, 9, 19),
      Array(18, 8, 23, 26, 20),
      Array(22, 11, 13, 6, 5),
      Array(2, 0, 12, 3, 7)
    ).map(_.map(_.toString))
    val expectedResult = Array(expectedBoard1, expectedBoard2, expectedBoard3)

    allBoards.head should equal(expectedResult.head)
    allBoards(1) should equal(expectedResult(1))
    allBoards(2) should equal(expectedResult(2))
  }

  behavior of "check if board is winner"
  it should "find winner - horizontal" in {
    val winningBoard = Array(
      Array("22", "13", "17", "11", "0"),
      Array("8", "2", "23", "4", "24"),
      Array("X", "X", "X", "X", "X"),
      Array("6", "10", "3", "18", "5"),
      Array("1", "12", "20", "15", "19")
    )
    Problem4.isWinner(winningBoard) should equal(true)
  }
  it should "find winner - horizontal - 2" in {
    val winningBoard = Array(
      Array("22", "13", "X", "X", "X"),
      Array("8", "X", "X", "X", "X"),
      Array("X", "X", "X", "16", "X"),
      Array("6", "10", "3", "18", "X"),
      Array("1", "12", "20", "15", "19")
    )
    Problem4.isWinner(winningBoard) should equal(false)
  }
  it should "find winner - vertical" in {
    val winningBoard = Array(
      Array("X", "13", "17", "11", "0"),
      Array("X", "2", "23", "4", "24"),
      Array("X", "9", "14", "16", "7"),
      Array("X", "10", "3", "18", "5"),
      Array("X", "12", "20", "15", "19")
    )
    Problem4.isWinner(winningBoard) should equal(true)
  }

  behavior of "solution finder"
  it should "find the correct solution" in {
    val filePath = "test-input-4"
    Problem4.solution(filePath) should equal(4512)
  }

  behavior of "solution finder part 2"
  it should "find the correct solution" in {
    val filePath = "test-input-4"
    Problem4.solution(filePath) should equal(1924)
  }

}
