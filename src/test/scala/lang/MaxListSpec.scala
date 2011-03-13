package lang

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec

class MaxListSpec extends Spec with ShouldMatchers {
  describe("Test MaxList's maxList method") {
    describe("when empty ") {
      it("should throw an Exception") {
        val maxListInstance = new MaxList
        evaluating {
          maxListInstance.maxList(Nil)
        } should produce[IllegalArgumentException]
      }
    }

    describe("when contains only one element") {
      it("should return that element") {
        val maxListInstance = new MaxList
        maxListInstance.maxList(List(1)) should be === 1
      }
    }

    describe("when contains more than one elements") {
      it("should return the max value") {
        val maxListInstance = new MaxList
        maxListInstance.maxList(List(13,2,14,5,7)) should be === 14
      }
    }
  }
}