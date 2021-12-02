package problem2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class Problem2Test extends AnyFlatSpec with Matchers {
  it should "test input solution" in {
    val filePath = "test-input-2"
    Problem2.solution(filePath) should equal(150)
  }

  it should "parse depth input - forward" in {
    Problem2.parseDepthMeter("forward 5") should equal((5, 0))
  }
  it should "parse depth input - down" in {
    Problem2.parseDepthMeter("down 3") should equal((0, 3))
  }
  it should "parse depth input - up" in {
    Problem2.parseDepthMeter("up 1") should equal((0, -1))
  }

}
