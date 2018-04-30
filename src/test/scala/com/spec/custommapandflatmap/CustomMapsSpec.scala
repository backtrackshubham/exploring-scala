package com.spec.custommapandflatmap

import com.blog.mapandflatmap.CustomMaps
import org.scalatest.WordSpec

class CustomMapsSpec extends WordSpec{
  val list = (1 to 5).toList
  val customMapsObject = CustomMaps[Int, Int](list)
  "A customMap"  should {
    "apply map operation" in {
      val lambda = (x: Int) => x + 1
      val expectedOutput = (2 to 6).toList
      assert(customMapsObject.customMap(lambda) == expectedOutput)
    }
    "apply flatMap operation" in {
      val lambdaForFlatMap = (x: Int) => List(x * 2, x * 3)
      val expectedOutput = List(2, 3, 4, 6, 6, 9, 8, 12, 10, 15)
      assert(customMapsObject.customFlatMap(lambdaForFlatMap) == expectedOutput)
    }
  }
}
