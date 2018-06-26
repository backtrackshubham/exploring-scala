package com.spec.custommapandflatmap

import com.blog.mapandflatmap.{FlatMapOnFuture, FutureRunningTasks}
import org.scalatest.Matchers.convertToAnyShouldWrapper
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{AsyncWordSpecLike, MustMatchers}

import scala.concurrent.Future

class FutureSpec extends AsyncWordSpecLike with TestData with MustMatchers {
  "A future task" must  {
    " transform value of future" in {
      FutureRunningTasks.futureTask map {
        value => assert(value == futureMapList)
      }
    }
    " show magic of flatMap" in {
      val result: Future[List[Int]] = FlatMapOnFuture.flatMapMagic
      ScalaFutures.whenReady(result.failed) { res =>
        res shouldBe a[Throwable]
      }
    }
  }
}
