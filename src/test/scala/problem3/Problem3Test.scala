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
    val coll = List('1', '1', '2', '3')
    Problem3.findMostCommonElementInCollection(coll) should equal('1')
  }
  it should "find most common element in a collection - Return 1 if most common are the same - 1" in {
    val coll = List('0', '1')
    Problem3.findMostCommonElementInCollection(coll) should equal('1')
  }
  it should "find most common element in a collection - Return 1 if most common are the same - 2" in {
    val coll = List('1', '0')
    Problem3.findMostCommonElementInCollection(coll) should equal('1')
  }

  it should "find least common element in a collection" in {
    val coll = List('1', '1', '2', '3', '3')
    Problem3.findLeastCommonElementInCollection(coll) should equal('2')
  }
  it should "find least common element in a collection - Return 0 if least common are the same - 1" in {
    val coll = List('0', '1')
    Problem3.findLeastCommonElementInCollection(coll) should equal('0')
  }
  it should "find least common element in a collection - Return 0 if least common are the same - 2" in {
    val coll = List('1', '0')
    Problem3.findLeastCommonElementInCollection(coll) should equal('0')
  }


  behavior of "rate finders"
  it should "find gamma rate" in {
    Problem3.findGammaRate(testInput) should equal("10110")
  }
  it should "find epsilon rate" in {
    Problem3.findEpsilonRate(testInput) should equal("01001")
  }
  it should "find Oxygen criteria" in {
    val input = List("100", "111", "010")
    Problem3.findLastRemainingOxygenBitCriteria(input) should equal("111")
  }
  it should "find Oxygen criteria - bigger input" in {
    Problem3.findLastRemainingOxygenBitCriteria(testInput) should equal("10111")
  }
  //  it should "find CO2 criteria" in {
  //    Problem3.findLastRemainingOxygenBitCriteria(testInput) should equal("10111")
  //  }

  behavior of "solution finder"
  it should "test solution" in {
    Problem3.solution(testFilePath) should equal(198)
  }

  it should "test solution part two" in {
    Problem3.solutionPartTwo(testFilePath) should equal(230)
  }
}
