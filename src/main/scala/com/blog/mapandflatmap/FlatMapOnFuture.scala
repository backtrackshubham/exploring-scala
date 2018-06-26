package com.blog.mapandflatmap

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object FlatMapOnFuture extends App{
  val res: Future[Future[List[Int]]] = FutureRunningTasksFlat.futureTask
//  Thread.sleep(3000)

  val usingMap: Future[Future[List[Int]]] = res.map(value => value.map(_.reverse))
  val usingFlatMap: Future[List[Int]] = res.flatMap(value => value.map(x => x.reverse))
  val usingFlatten: Future[List[Int]] = res.flatten.map(_.reverse)
  val flatMapMagic: Future[List[Int]] = FutureRunningTasksFlat.getTable(0) flatMap {
    case Nil => Future.failed(throw new RuntimeException("failed"))
    case table => Future.successful(table)
  }
  Thread.sleep(3000)
  println(s"\nResult using map on nested future \n $usingMap\n")
  println(s"Result using flatMap on nested future \n $usingFlatMap\n")
  println(s"Result using flatten on nested future \n $usingFlatten\n")
  println(flatMapMagic)
  /*val patternMatch = res flatMap {

  }*/
}

object FutureRunningTasksFlat {
  val list: List[Int] = (1 to 20).toList

  def futureTask: Future[Future[List[Int]]] = Future {
    Thread.sleep(1234)
    getTable(2)
  }

  def getTable(num: Int): Future[List[Int]] = Future {
    if(num == 0){
      List.empty[Int]
    } else {
      helper(List(), num, 1)
    }
  }

  private def helper(in: List[Int], num: Int, initial: Int): List[Int] = {
    if (initial == 11) in.reverse else helper(num * initial :: in, num, initial + 1)
  }
}