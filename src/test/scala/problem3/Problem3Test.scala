package problem3

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem3Test extends AnyFlatSpec with Matchers {
  val testFilePath = "test-input-3"
  val testInput: List[String] = Problem3.readInput(testFilePath)

  behavior of "binary number converter"
  it should "convert binary to decimal - 1" in {
    Problem3.convertBinaryToDecimal("10110") should equal(22)
  }
  it should "convert binary to decimal - 2" in {
    Problem3.convertBinaryToDecimal("01001") should equal(9)
  }


  behavior of "collection helpers"
  it should "find most common element in a collection" in {
    val coll = List(1, 2, 2, 3, 3, 3, 1, 1, 1, 1, 1)
    Problem3.findMostCommonElementInCollection(coll) should equal(1)
  }

  it should "find least common element in a collection" in {
    val coll = List(1, 2, 2, 3, 3, 3, 1, 1, 1, 1, 1)
    Problem3.findLeastCommonElementInCollection(coll) should equal(2)
  }


  behavior of "rate finders"
  it should "find gamma rate" in {
    Problem3.findGammaRate(testInput) should equal("10110")
  }

  it should "find epsilon rate" in {
    Problem3.findEpsilonRate(testInput) should equal("01001")
  }

  behavior of "solution finder"
  it should "test solution" in {
    Problem3.solution(testFilePath) should equal(198)
  }
}
