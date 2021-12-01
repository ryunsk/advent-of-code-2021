package problem1

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.io.Source

class Problem1Test extends AnyFlatSpec with Matchers {
  behavior of "file reader"
  it should "read input as array" in {
    val filePath = "test-input-1"
    val expectedResult = Array(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
    Problem1.readInput(filePath) should equal(expectedResult)
  }

  behavior of "solution finder"
  it should "find correct solution" in {
    val filePath = "test-input-1"
    val inputArray = Problem1.readInput(filePath)
    Problem1.compareTwoNumbersInArray(inputArray) should equal(7)
  }

  it should "find correct solution for three sliding window method" in {
    val filePath = "test-input-1"
    val inputArray = Problem1.readInput(filePath)
    Problem1.solution(inputArray) should equal(5)
  }

}
