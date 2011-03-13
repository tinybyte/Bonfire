package lang

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec

class MaxListSpec extends Spec with ShouldMatchers {
   describe("Test MaxList's maxList method") {
     describe("when empty ") {
       it("should throw an Exception"){
         val maxListInstance = new MaxList
         evaluating{maxListInstance.maxList(Nil)} should produce [IllegalArgumentException]
       }
     }

     describe("when contains only one element") {
       it("should return that element") {
        val maxListInstance = new MaxList
        maxListInstance.maxList(List(1)) should be === 1
       }
     }
   }
}